/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.dtstack.chunjun.connector.jdbc.lookup.provider;

import org.apache.flink.shaded.guava18.com.google.common.base.CaseFormat;

import com.alibaba.druid.pool.DruidDataSource;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.jdbc.spi.DataSourceProvider;

import javax.sql.DataSource;

import java.util.Map;
import java.util.Properties;

/**
 * @program chunjun
 * @author: wuren
 * @create: 2021/04/28
 */
public class DruidDataSourceProvider implements DataSourceProvider {

    @Override
    public DataSource getDataSource(JsonObject config) {
        DruidDataSource dataSource = new DruidDataSource();
        Properties props = new Properties();
        for (Map.Entry<String, Object> entry : config) {
            String key = entry.getKey();
            if (!"provider_class".equals(key)) {
                String formattedName = CaseFormat.LOWER_HYPHEN.to(CaseFormat.LOWER_CAMEL, key);
                props.setProperty(formattedName, entry.getValue().toString());
            }
        }
        dataSource.configFromPropety(props);
        return dataSource;
    }

    @Override
    public void close(DataSource dataSource) {
        if (dataSource instanceof DruidDataSource) {
            ((DruidDataSource) dataSource).close();
        }
    }

    @Override
    public int maximumPoolSize(DataSource dataSource, JsonObject config) {
        if (dataSource instanceof DruidDataSource) {
            return ((DruidDataSource) dataSource).getMaxActive();
        }
        return -1;
    }
}
