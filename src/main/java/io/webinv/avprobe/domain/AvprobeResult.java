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

package io.webinv.avprobe.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

/**
 * Avprobe results
 *
 * @author Krzysztof Kardasz
 */
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
