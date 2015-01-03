/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.tamaya.core.formats;

import org.apache.tamaya.core.resources.Resource;
import org.apache.tamaya.spi.PropertySource;

import java.io.IOException;
import java.util.Collection;

/**
 * Implementations current this class encapsulate the mechanism how to read a
 * resource including interpreting the format correctly (e.g. xml vs.
 * properties). In most cases file only contains entries of the same priority, which would then
 * result in only one {@link PropertySource}. Complex file formats, hoiwever, may contain entries
 * of different priorities. In this cases, each ordinal type found must be returned as a separate
 * {@link PropertySource} instance.
 */
@FunctionalInterface
public interface ConfigurationFormat{

    /**
     * Reads a list {@link org.apache.tamaya.spi.PropertySource} instances from a resource, using this format.
     * Hereby the ordinal given is used as a base ordinal
     * @param resource    the configuration resource, not null
     * @return the corresponding {@link java.util.Map}, never {@code null}.
     */
    Collection<PropertySource> readConfiguration(Resource resource)throws IOException;

}