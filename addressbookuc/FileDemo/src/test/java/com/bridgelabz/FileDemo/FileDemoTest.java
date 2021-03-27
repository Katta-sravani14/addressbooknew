package com.bridgelabz.FileDemo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;

import org.junit.Assert;
import org.junit.Test;

public class FileDemoTest {
	private static String HOME = System.getProperty("user.home");
	private static String PlayWithNIO = "Play Ground";

	@Test
	public void givenPath_CheckIfFileExists_ThenReturnPath() throws IOException {

		//Check if File Exists
		Path homePath = Paths.get(HOME);
		System.out.println(homePath);
		Assert.assertTrue(Files.exists(homePath));

		//Delete File and Check File Not Exist
		Path playPath = Paths.get(HOME + "/" + PlayWithNIO);
		if(Files.exists(playPath))
			FileDemo.deleteFiles(playPath.toFile());
		Assert.assertTrue(Files.notExists(playPath));

		//Create Directory
		Files.createDirectories(playPath);
		Assert.assertTrue(Files.exists(playPath));

		//Create Empty File
		IntStream.range(1, 10).forEach(cntr -> {
			Path tempFile = Paths.get(playPath + "/temp" + cntr);
			try {
				Files.createFile(tempFile);
			}
			catch (IOException e) {
			}
			Assert.assertTrue(Files.exists(tempFile));
		});

		//List Files, Directories as well as Files with Extension
		Files.list(playPath).filter(Files::isRegularFile).forEach(System.out::println);
		Files.newDirectoryStream(playPath, path -> path.toFile().isFile() && path.toString()
					.startsWith("temp")).forEach(System.out::println);
	}

}