package com.example.databasefun.db;

import java.io.IOException;

import org.hsqldb.persist.HsqlProperties;
import org.hsqldb.server.Server;
import org.hsqldb.server.ServerAcl.AclFormatException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HSQLDBRunner {

	private Logger logger = LoggerFactory.getLogger(getClass());

	private void run(String[] args) {
		if (args.length < 3) {
			logger.error("Usage HSQLDBRunner <targetFolderFlag> ('target'|'physical')> <physical-folder-name> <createFlag ('true'|'false')>");
			System.exit(0);
		}

		String targetFlag = args[0].trim();
		String physicalFolder = args[1].trim();
		boolean create = args[2].trim().equalsIgnoreCase("true");

		if (targetFlag.equalsIgnoreCase("true")) {
			physicalFolder = "target";
		}

		physicalFolder = physicalFolder.replaceAll("\\\\", "/");

		if (!physicalFolder.endsWith("/")) {
			physicalFolder = physicalFolder + "/";
		}

		physicalFolder = physicalFolder + "thedatabase";

		HsqlProperties p = new HsqlProperties();
		p.setProperty("server.dbname.0", "thedatabase");
		p.setProperty("sever.port", "9001");
		p.setProperty("server.database.0", "file:" + physicalFolder);

		if (create) {
			p.setProperty("create", "true");
			logger.info("Creating database at: " + physicalFolder);
		} else {
			logger.info("Using database at: " + physicalFolder);
		}

		logger.info("Starting database...");

		Server server = new Server();

		try {
			server.setProperties(p);
			server.setLogWriter(null);
			server.setErrWriter(null);
			server.start();
		} catch (IOException | AclFormatException e) {
			logger.error("Could not start server." + e);
		}
	}

	public static void main(String[] args) {
		HSQLDBRunner runner = new HSQLDBRunner();
		runner.run(args);
	}
}
