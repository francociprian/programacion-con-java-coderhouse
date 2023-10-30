package com.ciprian.FacturacionEntregaFinalCiprian.middleware;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResponseHandler {
  public static ResponseEntity<Object> generateResponse(
      String message,
      HttpStatus status,
      Object responseObj) {
    Map<String, Object> map = new HashMap<>();
    map.put("message", message);
    map.put("status", status.value());

    if (responseObj != null) {
      map.put("data", responseObj);

      if (responseObj instanceof List) {
        List<?> dataList = (List<?>) responseObj;
        map.put("count", dataList.size());
      }
    }

    return new ResponseEntity<>(map, status);
  }
}