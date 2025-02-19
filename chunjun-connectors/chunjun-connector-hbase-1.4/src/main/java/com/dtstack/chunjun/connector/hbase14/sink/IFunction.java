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

package com.dtstack.chunjun.connector.hbase14.sink;

/**
 * @company: www.dtstack.com
 * @author: toutian
 * @create: 2019/7/23
 */
public interface IFunction {

    /**
     * 具体的计算方法
     *
     * @param val 输入参数
     * @return 计算结果
     * @throws Exception 捕获的异常，异常类型不确定
     */
    String evaluate(Object val) throws Exception;
}
