/*
 * Copyright 2014-2015 Time Warner Cable, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.twcable.gradle.cqpackage

import groovy.transform.CompileStatic
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

/**
 * A task that will (re)write the filter.xml file with bundle files.
 *
 * @see FilterXmlWriter
 */
@CompileStatic
class AddBundlesToFilterXmlTask extends DefaultTask {
    /**
     * Where to find the "source" XML that will be modified with the bundles.
     */
    Reader filterXmlReader

    /**
     * Where the modified XML will be written.
     */
    Writer filterXmlWriter


    @TaskAction
    @SuppressWarnings("GroovyUnusedDeclaration")
    void writeFile() {
        def xmlWriter = FilterXmlWriter.builder(project).
            inReader(filterXmlReader). // if not set, will use default
            outWriter(filterXmlWriter). // if not set, will use default
            build()
        xmlWriter.run()
    }

}
