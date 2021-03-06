package com.agenarisk.api.io;

import com.agenarisk.api.exception.AdapterException;
import com.agenarisk.api.util.JSONUtils;
import com.agenarisk.test.TestHelper;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

/**
 * The purpose of this test file is to make sure that it extracts the same JSONObject regardless of whether XML or JSON file path was provided.
 *
 * @author Eugene Dementiev
 */
public class FileAdapterTest {

	@Test
	public void testJsonToXmlFromFiles() throws IOException {
		// Get all json files
		List<String> pathsInJson = new ArrayList<>();
		List<String> pathsInXml = new ArrayList<>();

		TestHelper.copyInputOuputResources(Paths.get("com", "agenarisk", "api", "io", "FileAdapterTest"), "cmpx", "xml", pathsInJson, pathsInXml);

		Assertions.assertFalse(pathsInJson.isEmpty());
		assertEquals(pathsInJson.size(), pathsInXml.size());

		for (int i = 0; i < pathsInJson.size(); i++) {

			JSONObject json1 = null;
			JSONObject json2 = null;

			try {
				json1 = FileAdapter.extractJSONObject(pathsInJson.get(i));
				json2 = FileAdapter.extractJSONObject(pathsInXml.get(i));
			}
			catch (AdapterException ex) {
				ex.printStackTrace();
				fail("Failed to extract");
			}

			if (json1 == null || json2 == null) {
				fail("One of the files was not extracted");
			}

			assertTrue(JSONUtils.equalsIgnoreCase(json1, json2));

		}
	}
}
