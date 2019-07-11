/***************************************************************************
 * Copyright (c) 2019 TAOS Data, Inc. <jhtao@taosdata.com>
 *
 * This program is free software: you can use, redistribute, and/or modify
 * it under the terms of the GNU Affero General Public License, version 3
 * or later ("AGPL"), as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/
package com.taosdata.jdbc;

import java.sql.ResultSet;

/*
 * TDengine only supports a subset of the standard SQL, thus this implemetation of the
 * standard JDBC API contains more or less some adjustments customized for certain
 * compatibility needs.
 */
public class GetColumnsResultSet extends TSDBResultSetWrapper {
    private String catalog;
    private String schemaPattern;
    private String tableNamePattern;
    private String columnNamePattern;

    public GetColumnsResultSet(ResultSet resultSet, String catalog, String schemaPattern, String tableNamePattern, String columnNamePattern) {
        super.setOriginalResultSet(resultSet);
        this.catalog = catalog;
        this.schemaPattern = schemaPattern;
        this.tableNamePattern = tableNamePattern;
        this.columnNamePattern = columnNamePattern;
    }

    @Override
    public String getString(int columnIndex) {
        switch (columnIndex) {
            case 1:
                return catalog;
            case 2:
                return null;
            case 3:
                return tableNamePattern;
            default:
                return null;
        }
    }
}
