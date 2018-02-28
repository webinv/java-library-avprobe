package io.webinv.avprobe;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.webinv.avprobe.domain.AvprobeResult;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

public class Avprobe
{
    private final Logger logger = LogManager.getLogger(this.getClass());

    private String avProbeBinPath = "avprobe";

    public String getAvProbeBinPath()
    {
        return avProbeBinPath;
    }

    public void setAvProbeBinPath(String avProbeBinPath)
    {
        this.avProbeBinPath = avProbeBinPath;
    }

    public AvprobeResult getInfo (String filepath) throws IOException, InterruptedException
    {
        ProcessBuilder pb = new ProcessBuilder(getAvProbeBinPath(),
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
