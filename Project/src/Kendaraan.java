/**
 * KELAS ABSTRACT: Kendaraan
 * Menjadi kerangka dasar untuk semua jenis kendaraan.
 * Subkelas WAJIB mengimplementasikan metode infoKendaraan().
 */
public abstract class Kendaraan {
    protected String merk;
    protected int    tahun;
    protected double kecepatan; // km/jam

    public Kendaraan(String merk, int tahun) {
        this.merk       = merk;
        this.tahun      = tahun;
        this.kecepatan  = 0;
    }

    // Metode abstract — wajib di-override oleh subkelas
    public abstract void infoKendaraan();

    // Metode konkret yang diwarisi oleh subkelas
    public void tambahKecepatan(double delta) {
        kecepatan += delta;
        System.out.printf("  [Kendaraan] Kecepatan sekarang: %.1f km/jam%n", kecepatan);
    }

    public void kurangiKecepatan(double delta) {
        kecepatan = Math.max(0, kecepatan - delta);
        System.out.printf("  [Kendaraan] Kecepatan sekarang: %.1f km/jam%n", kecepatan);
    }

    public String getMerk()    { return merk; }
    public int    getTahun()   { return tahun; }
    public double getKecepatan() { return kecepatan; }
}
