package com.iris.service;

import java.util.Map;

public interface UpdateBoardService {

	Map<String, Object> findByVersion(String version, String hash);
}
