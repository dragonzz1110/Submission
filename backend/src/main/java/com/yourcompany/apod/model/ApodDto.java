package com.yourcompany.apod.model;

public class ApodDto {
    private String date;
    private String title;
    private String explanation;
    private String mediaUrl;
    private String hdMediaUrl;
    private String thumbnailUrl;
    private ApodMediaType mediaType;
    private String copyright;

    public ApodDto() {
    }

    public ApodDto(String date,
                   String title,
                   String explanation,
                   String mediaUrl,
                   String hdMediaUrl,
                   String thumbnailUrl,
                   ApodMediaType mediaType,
                   String copyright) {
        this.date = date;
        this.title = title;
        this.explanation = explanation;
        this.mediaUrl = mediaUrl;
        this.hdMediaUrl = hdMediaUrl;
        this.thumbnailUrl = thumbnailUrl;
        this.mediaType = mediaType;
        this.copyright = copyright;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getMediaUrl() {
        return mediaUrl;
    }

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }

    public String getHdMediaUrl() {
        return hdMediaUrl;
    }

    public void setHdMediaUrl(String hdMediaUrl) {
        this.hdMediaUrl = hdMediaUrl;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public ApodMediaType getMediaType() {
        return mediaType;
    }

    public void setMediaType(ApodMediaType mediaType) {
        this.mediaType = mediaType;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }
}
