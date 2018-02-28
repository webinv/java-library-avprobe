/*
 * Copyright 2002-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.webinv.avprobe;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.webinv.avprobe.domain.AvprobeResult;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * Avprobe reader
 *
 * @author Krzysztof Kardasz <krzysztof@kardasz.eu>
 */
public class Avprobe
{
    /**
     * Logger
     */
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * avprobe binary path
     */
    private String avprobePath = "avprobe";

    /**
     * Return avprobe binary path
     */
    public String getAvprobePath()
    {
        return avprobePath;
    }

    /**
     * @param avprobePath avprobe binary path
     */
    public void setAvprobePath(String avprobePath)
    {
        this.avprobePath = avprobePath;
    }

    /**
     * Reads metadata from video
     *
     * @param filepath video file path
     */
    public AvprobeResult getInfo (String filepath) throws IOException, InterruptedException
    {
        ProcessBuilder pb = new ProcessBuilder(getAvprobePath(),
                "-v", "quiet",
                "-show_format",
                "-show_streams",
                "-of", "json",
                filepath
        );

        logger.debug(pb.command());

        pb.redirectErrorStream(false);
        Process p = pb.start();

        InputStream is = p.getInputStream();
        p.waitFor();

        String results = IOUtils.toString(is, Charset.forName("UTF-8"));

        logger.debug(results);

        if (0 == p.exitValue()) {
            return  (new ObjectMapper()).readValue(results, AvprobeResult.class);
        } else {
            logger.error("Command: {}, exit code: {}, Results: {}", String.join(" ",  pb.command()), p.exitValue(), results);
        }

        return null;
    }
}
