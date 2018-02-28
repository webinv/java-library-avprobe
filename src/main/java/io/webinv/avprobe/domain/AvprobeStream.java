package io.webinv.avprobe.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AvprobeStream {
    private int index;

    @JsonProperty("codec_name")
    private String codecName;

    @JsonProperty("codec_long_name")
    private String codecLongName;

    @JsonProperty("codec_type")
    private String codecType;

    @JsonProperty("codec_time_base")
    private String codecTimeBase;

    @JsonProperty("codec_tag_string")
    private String codecTagString;

    @JsonProperty("codec_tag")
    private String codecTag;

    @JsonProperty("sample_rate")
    private Double sampleRate;

    private Integer channels;

    @JsonProperty("bits_per_sample")
    private String bitsPerSample;

    private String profile;

    private String width;

    private String height;

    @JsonProperty("has_b_frames")
    private String hasBFrames;

    @JsonProperty("sample_aspect_ratio")
    private String sampleAspectRatio;

    @JsonProperty("display_aspect_ratio")
    private String displayAspectRatio;

    @JsonProperty("pix_fmt")
    private String pixFmt;

    private String level;

    @JsonProperty("avg_frame_rate")
    private String avgFrameRate;

    @JsonProperty("bit_rate")
    private Double bitRate;

    @JsonProperty("time_base")
    private String timeBase;

    @JsonProperty("start_time")
    private Double startTime;

    private Double duration;

    @JsonProperty("nb_frames")
    private Integer nbFrames;

    private Map<String, String> tags;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getCodecName() {
        return codecName;
    }

    public void setCodecName(String codecName) {
        this.codecName = codecName;
    }

    public String getCodecLongName() {
        return codecLongName;
    }

    public void setCodecLongName(String codecLongName) {
        this.codecLongName = codecLongName;
    }

    public String getCodecType() {
        return codecType;
    }

    public void setCodecType(String codecType) {
        this.codecType = codecType;
    }

    public String getCodecTimeBase() {
        return codecTimeBase;
    }

    public void setCodecTimeBase(String codecTimeBase) {
        this.codecTimeBase = codecTimeBase;
    }

    public String getCodecTagString() {
        return codecTagString;
    }

    public void setCodecTagString(String codecTagString) {
        this.codecTagString = codecTagString;
    }

    public String getCodecTag() {
        return codecTag;
    }

    public void setCodecTag(String codecTag) {
        this.codecTag = codecTag;
    }

    public Double getSampleRate() {
        return sampleRate;
    }

    public void setSampleRate(Double sampleRate) {
        this.sampleRate = sampleRate;
    }

    public Integer getChannels() {
        return channels;
    }

    public void setChannels(Integer channels) {
        this.channels = channels;
    }

    public String getBitsPerSample() {
        return bitsPerSample;
    }

    public void setBitsPerSample(String bitsPerSample) {
        this.bitsPerSample = bitsPerSample;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getHasBFrames() {
        return hasBFrames;
    }

    public void setHasBFrames(String hasBFrames) {
        this.hasBFrames = hasBFrames;
    }

    public String getSampleAspectRatio() {
        return sampleAspectRatio;
    }

    public void setSampleAspectRatio(String sampleAspectRatio) {
        this.sampleAspectRatio = sampleAspectRatio;
    }

    public String getDisplayAspectRatio() {
        return displayAspectRatio;
    }

    public void setDisplayAspectRatio(String displayAspectRatio) {
        this.displayAspectRatio = displayAspectRatio;
    }

    public String getPixFmt() {
        return pixFmt;
    }

    public void setPixFmt(String pixFmt) {
        this.pixFmt = pixFmt;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getAvgFrameRate() {
        return avgFrameRate;
    }

    public void setAvgFrameRate(String avgFrameRate) {
        this.avgFrameRate = avgFrameRate;
    }

    public Double getBitRate() {
        return bitRate;
    }

    public void setBitRate(Double bitRate) {
        this.bitRate = bitRate;
    }

    public String getTimeBase() {
        return timeBase;
    }

    public void setTimeBase(String timeBase) {
        this.timeBase = timeBase;
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

    public Integer getNbFrames() {
        return nbFrames;
    }

    public void setNbFrames(Integer nbFrames) {
        this.nbFrames = nbFrames;
    }

    public Map<String, String> getTags() {
        return tags;
    }

    public void setTags(Map<String, String> tags) {
        this.tags = tags;
    }

    public boolean isCodecType(CodecType type) {
        CodecType codecType = CodecType.getCodecTypeOf(this.codecType);
        return null != codecType && type.equals(codecType);
    }

    public enum CodecType {
        AUDIO, VIDEO;

        public static CodecType getCodecTypeOf(String value) {
            if (null == value || value.isEmpty()) {
                return null;
            }

            String formatted = value.toUpperCase();
            for (CodecType type : values()) {
                if (type.toString().equals(formatted)) {
                    return type;
                }
            }

            return null;
        }
    }

}

