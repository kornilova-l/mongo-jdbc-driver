package com.dbschema.mongo;

import java.sql.DriverPropertyInfo;
import java.util.ArrayList;

public class DriverPropertyInfoHelper {
  public static final String CONNECTIONS_PER_HOST = "connectionsPerHost";
  public static final String CONNECT_TIMEOUT = "connectTimeout";
  public static final String CURSOR_FINALIZER_ENABLED = "cursorFinalizerEnabled";
  public static final String READ_PREFERENCE = "readPreference";
  public static final String SOCKET_TIMEOUT = "socketTimeout";
  public static final String FETCH_DOCUMENTS_FOR_METAINFO = "fetch_documents_for_metainfo";
  public static final int FETCH_DOCUMENTS_FOR_METAINFO_DEFAULT = 10;
  public static final String USE_ES6 = "use_ecmascript_6";
  public static final boolean USE_ES6_DEFAULT = true;
  public static final String MAX_POOL_SIZE = "max_connection_pool_size";
  public static final int MAX_POOL_SIZE_DEFAULT = 3;
  private static final String GET_MAX_SIZE_DOCS = "https://mongodb.github.io/mongo-java-driver/3.6/javadoc/com/mongodb/connection/ConnectionPoolSettings.html#getMaxSize--";


  public DriverPropertyInfo[] getPropertyInfo() {
    ArrayList<DriverPropertyInfo> propInfos = new ArrayList<>();

    addPropInfo(propInfos, CONNECTIONS_PER_HOST, "10", "The maximum number of connections allowed per "
        + "host for this Mongo instance. Those connections will be kept in a pool when idle. Once the "
        + "pool is exhausted, any operation requiring a connection will block waiting for an available "
        + "connection.", null);

    addPropInfo(propInfos, CONNECT_TIMEOUT, "10000", "The connection timeout in milliseconds. A value "
        + "of 0 means no timeout. It is used solely when establishing a new connection "
        + "Socket.connect(java.net.SocketAddress, int)", null);

    addPropInfo(propInfos, CURSOR_FINALIZER_ENABLED, "true", "Sets whether there is a a finalize "
            + "method created that cleans up instances of DBCursor that the client does not close. If you "
            + "are careful to always call the close method of DBCursor, then this can safely be set to false.",
        null);

    addPropInfo(propInfos, READ_PREFERENCE, "primary",
        "represents preferred replica set members to which a query or command can be sent", new String[]{
            "primary", "primary preferred", "secondary", "secondary preferred", "nearest"});

    addPropInfo(propInfos, SOCKET_TIMEOUT, "0", "The socket timeout in milliseconds It is used for "
        + "I/O socket read and write operations "
        + "Socket.setSoTimeout(int) Default is 0 and means no timeout.", null);

    addPropInfo(propInfos, FETCH_DOCUMENTS_FOR_METAINFO, Integer.toString(FETCH_DOCUMENTS_FOR_METAINFO_DEFAULT), "Number of documents that will be fetched per collection in order " +
        "to return meta information from DatabaseMetaData.getColumns method.", null);

    addPropInfo(propInfos, USE_ES6, Boolean.toString(USE_ES6_DEFAULT), "Start Nashorn script engine with ecmascript 6 standard", null);

    addPropInfo(propInfos, MAX_POOL_SIZE, Integer.toString(MAX_POOL_SIZE_DEFAULT), "MongoDB connections pool size per one connection from IDE. See " + GET_MAX_SIZE_DOCS, null);

    return propInfos.toArray(new DriverPropertyInfo[0]);
  }

  private void addPropInfo(final ArrayList<DriverPropertyInfo> propInfos, final String propName,
                           final String defaultVal, final String description, final String[] choices) {
    DriverPropertyInfo newProp = new DriverPropertyInfo(propName, defaultVal);
    newProp.description = description;
    if (choices != null) {
      newProp.choices = choices;
    }
    propInfos.add(newProp);
  }
}
