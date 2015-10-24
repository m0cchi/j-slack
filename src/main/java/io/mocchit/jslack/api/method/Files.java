package io.mocchit.jslack.api.method;

import io.mocchit.jslack.api.ApiUtil;
import io.mocchit.jslack.api.BaseAPI;
import io.mocchit.jslack.api.Result;

import java.util.Map;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public interface Files extends BaseAPI {

	/**
	 * Deletes a file.
	 * 
	 * @param file
	 *            ID of file to delete.
	 * @return
	 */
	default Result deleteFile(String file) {
		StringBuilder builder = new StringBuilder(getTokenParam());
		builder.append(ApiUtil.concat("file", file));
		return send("files.delete", builder.toString());
	}

	/**
	 * Gets information about a team file.
	 * 
	 * @param file
	 *            File to fetch info for
	 * @param optionals
	 *            https://api.slack.com/methods/files.info
	 * @return
	 */
	default Result fetchFileInfo(String file, Map<String, String> optionals) {
		StringBuilder builder = new StringBuilder(getTokenParam());
		builder.append(ApiUtil.concat("file", file));
		builder.append(ApiUtil.toParam(optionals));
		return send("files.info", builder.toString());
	}

	/**
	 * Lists & filters team files.
	 * 
	 * @param optionals
	 *            https://api.slack.com/methods/files.list
	 * @return
	 */
	default Result fetchFileList(Map<String, String> optionals) {
		StringBuilder builder = new StringBuilder(getTokenParam());
		builder.append(ApiUtil.toParam(optionals));
		return send("files.list", builder.toString());
	}

	/**
	 * Lists & filters team files.
	 * 
	 * @return
	 */
	default Result fetchFileList() {
		return fetchFileList(null);
	}

	// Uploads or creates a file.
	default Result uploadFile() {
		throw new NotImplementedException();
	}
}
