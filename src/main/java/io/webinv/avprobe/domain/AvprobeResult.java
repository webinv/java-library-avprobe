package io.webinv.avprobe.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AvprobeResult {
    private AvprobeFormat format;
    private List<AvprobeStream> streams;

    public AvprobeFormat getFormat() {
        return format;
    }

    public void setFormat(AvprobeFormat format) {
        this.format = format;
    }

    public List<AvprobeStream> getStreams() {
        return streams;
    }

    public void setStreams(List<AvprobeStream> streams) {
        this.streams = streams;
    }

    public AvprobeStream getStreamAudio ()
    {
        return getStreamByCodecType(AvprobeStream.CodecType.AUDIO);
    }

    public AvprobeStream getStreamVideo ()
    {
        return getStreamByCodecType(AvprobeStream.CodecType.VIDEO);
    }

    public AvprobeStream getStreamByCodecType (AvprobeStream.CodecType codecType)
    {
        if (null == streams || streams.isEmpty()) {
            return null;
        }

        for (AvprobeStream stream : streams) {
            if (stream.isCodecType(codecType)) {
                return stream;
            }
        }

        return null;
    }

    public boolean containsStreamByCodecType (AvprobeStream.CodecType codecType)
    {
        return null != getStreamByCodecType(codecType);
    }

    public boolean containsStreamAudio ()
    {
        return containsStreamByCodecType(AvprobeStream.CodecType.AUDIO);
    }

    public boolean containsStreamVideo ()
    {
        return containsStreamByCodecType(AvprobeStream.CodecType.VIDEO);
    }

    public boolean containsStreamAudioVideo ()
    {
        return containsStreamVideo() && containsStreamAudio();
    }
}
