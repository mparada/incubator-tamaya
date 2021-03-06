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
package org.apache.tamaya.core.properties;

import java.io.Serializable;
import java.util.*;

import org.apache.tamaya.spi.PropertySource;

/**
 * Abstract base class for implementing a {@link org.apache.tamaya.spi.PropertySource}.
 */
public abstract class AbstractPropertySource implements PropertySource, Serializable{
    /**
     * serialVersionUID.
     */
    private static final long serialVersionUID = -6553955893879292837L;

    protected String name;

    /**
     * Constructor.
     */
    protected AbstractPropertySource(String name){
        this.name = Objects.requireNonNull(name);
    }

    @Override
    public String getName(){
        return name;
    }


    @Override
    public Optional<String> get(String key){
        return Optional.ofNullable(getProperties().get(key));
    }

    @Override
    public String toString(){
        return getClass().getSimpleName()) + "(name=" + getName()+")");
    }

}
