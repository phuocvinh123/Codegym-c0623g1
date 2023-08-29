package bai13;

import java.time.LocalDate;

public class Certificate {
    private long certificatedId;
    private String certificatedName;
    private String certificatedRank;
    private LocalDate certificatedDate;

    public Certificate(long certificatedId, String certificatedName, String certificatedRank, LocalDate certificatedDate) {
        this.certificatedId = certificatedId;
        this.certificatedName = certificatedName;
        this.certificatedRank = certificatedRank;
        this.certificatedDate = certificatedDate;
    }

    public long getCertificatedId() {
        return certificatedId;
    }

    public void setCertificatedId(long certificatedId) {
        this.certificatedId = certificatedId;
    }

    public String getCertificatedName() {
        return certificatedName;
    }

    public void setCertificatedName(String certificatedName) {
        this.certificatedName = certificatedName;
    }

    public String getCertificatedRank() {
        return certificatedRank;
    }

    public void setCertificatedRank(String certificatedRank) {
        this.certificatedRank = certificatedRank;
    }

    public LocalDate getCertificatedDate() {
        return certificatedDate;
    }

    public void setCertificatedDate(LocalDate certificatedDate) {
        this.certificatedDate = certificatedDate;
    }

    @Override
    public String toString() {
        return "certificatedId= " + certificatedId +
                ", certificatedName= '" + certificatedName + '\'' +
                ", certificatedRank= '" + certificatedRank + '\'' +
                ", certificatedDate= " + certificatedDate ;
    }
}
