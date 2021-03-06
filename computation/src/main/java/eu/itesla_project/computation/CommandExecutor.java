/**
 * Copyright (c) 2016, All partners of the iTesla project (http://www.itesla-project.eu/consortium)
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package eu.itesla_project.computation;

import java.nio.file.Path;

/**
 *
 * @author Geoffroy Jamgotchian <geoffroy.jamgotchian at rte-france.com>
 */
@Deprecated
public interface CommandExecutor extends AutoCloseable {

    @Deprecated
    Path getWorkingDir();

    @Deprecated
    void start(CommandExecution execution, ExecutionListener listener) throws Exception;

    @Deprecated
    ExecutionReport start(CommandExecution execution) throws Exception;

}