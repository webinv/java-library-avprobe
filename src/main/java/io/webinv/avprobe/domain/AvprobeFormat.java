package io.webinv.avprobe.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AvprobeFormat {
    private String filename;

    @JsonProperty("nb_streams")
    private String nbStreams;

    @JsonProperty("format_name")
    private String formatName;

    @JsonProperty("format_long_name")
    private String formatLongName;

    @JsonProperty("start_time")
    private Double startTime;

    private Double duration;

    private Double size;

    @JsonProperty("bit_rate")
    private Double bitRate;

    private Map<String, String> tags;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getNbStreams() {
        return nbStreams;
    }

    public void setNbStreams(String nbStreams) {
        this.nbStreams = nbStreams;
    }

    public String getFormatName() {
        return formatName;
    }

    public void setFormatName(String formatName) {
        this.formatName = formatName;
    }

    public String getFormatLongName() {
        return formatLongName;
    }

    public void setFormatLongName(String formatLongName) {
        this.formatLongName = formatLongName;
    }

    public Double getStartTime() {
        return startTime;
    }

    public void setStartTime(Double startTime) {
        this.startTime = startTime;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public Double getBitRate() {
        return bitRate;
    }

    public void setBitRate(Double bitRate) {
        this.bitRate = bitRate;
    }

    public Map<String, String> getTags() {
        return tags;
    }

    public void setTags(Map<String, String> tags) {
        this.tags = tags;
    }
}
