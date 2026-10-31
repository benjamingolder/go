package ch.golders.backend.domain;

public class Auto {

    private final String id;
    private final String marke;
    private final String modell;
    private final int sitze;
    private final int tueren;
    private final String getriebe;
    private final String kennzeichen;
    private final double nutzlast;
    private final double ladevolumen;
    private final Kraftstoff kraftstoff;
    private AutoStatus autoStatus;

    public Auto(String id, String marke, String modell, int sitze, int tueren, String getriebe, String kennzeichen, double nutzlast, double ladevolumen, Kraftstoff kraftstoff) {
        this.id = id;
        this.marke = marke;
        this.modell = modell;
        this.sitze = sitze;
        this.tueren = tueren;
        this.getriebe = getriebe;
        this.kennzeichen = kennzeichen;
        this.nutzlast = nutzlast;
        this.ladevolumen = ladevolumen;
        this.kraftstoff = kraftstoff;
        this.autoStatus = AutoStatus.VERFUEGBAR;
    }

    public String getId() {
        return id;
    }

    public String getMarke() {
        return marke;
    }

    public String getModell() {
        return modell;
    }

    public int getSitze() {
        return sitze;
    }

    public int getTueren() {
        return tueren;
    }

    public String getGetriebe() {
        return getriebe;
    }

    public String getKennzeichen() {
        return kennzeichen;
    }

    public double getNutzlast() {
        return nutzlast;
    }

    public double getLadevolumen() {
        return ladevolumen;
    }

    public Kraftstoff getKraftstoff() {
        return kraftstoff;
    }

    public AutoStatus getAutoStatus() {
        return autoStatus;
    }

}
