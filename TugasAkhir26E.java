import java.util.Scanner;

public class TugasAkhir26E {
    static Scanner riska = new Scanner(System.in);
    static Scanner riska1 = new Scanner(System.in);
    static Scanner riska2 = new Scanner(System.in);
    static Scanner riska3 = new Scanner(System.in);
    static int pilihMenu, pilihMenulap;
    static String noRek;
    static String ktp;
    static String nama;
    static String pin;
    static String alamat;
    static String noHP;
    static String jenisTabungan;
    static int saldoAwal;
    static int opsiTabungan;
    static int ambilSaldo;
    static int totalSaldo;
    static char ulang;
    static int p;
    static String dataNasabah[][]={{"1","3505094901040001","riska","123","blitar","085607178754","Tabungan", "Aktif"},
                                   {"2","3505010879805660","kurnia","121","malang","085770897460","Giro\t", "Aktif"},
                                   {"3","3505094912344555","wulan","564","nglegok","081553566113","Deposito", "Aktif"}};
    static int dataNasabah2[]={1000000,2000000,3000000};
    static String dataSementara[][];
    static int dataSementara2[];
    static String histori[]={"Login","Menambahkan Data","Menampilkan Data", "Ubah Data Nasabah","Cek Saldo", "Tutup Akun", "Blokir ATM"};
    static int histori2[]={        1,0,0,0,0,0,0};

    //Login
    static void loginCS26E(){
    boolean regist = true;
    String userLogin = "riska";
    String pwLogin = "123";
    while(regist){
        for(int i = 2; i >= 1; i--){
        System.out.print("Username : ");
        String userLogin1 = riska.nextLine();
        System.out.print("Password : ");
        String pwLogin1 = riska.nextLine();
            if(userLogin1.equalsIgnoreCase(userLogin) && pwLogin1.equals(pwLogin)){
                System.out.println();
                System.out.println("\tSelamat Datang ADMIN");
                System.out.println();
                regist = false;
                break;
            } else if ( i == 1 ){
                System.out.println("Anda sudah 2x salah, tunggu untuk login kembali");
            } else {
                System.out.println("Username atau password salah, silakan login kembali " + "(kesempatan login " + (i-1) + "x lagi)");
            }
        }
        }
    }

    //Menu
    public static void menu26E() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("\t\t\tMENU");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("1. Menambahkan Data Nasabah dan Pembuatan ATM");
        System.out.println("2. Menampilkan Data Nasabah");
        System.out.println("3. Ubah Data Nasabah");
        System.out.println("4. Cek Saldo Nasabah");
        System.out.println("5. Tutup Akun Nasabah");
        System.out.println("6. Blokir Akun dan ATM");
        System.out.println("7. Laporan Kegiatan CS");
        System.out.println("8. Laporan Kehilangan");
        System.out.print("Masukkan Menu [1/2/3/4/5/6/7] : ");
        pilihMenu = riska.nextInt();
        System.out.println();
    }


    static void menuLaporankeh(){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("\t\t\tMENU");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("1. Blokir Akun dan ATM");
        System.out.println("2. Tutup Akun Nasabah");
        System.out.println("3. Ubah Akun Nasabah");
        pilihMenulap = riska3.nextInt();
        System.out.println();
    }
    //8.
    static void laporanKehilangan26E(){
        System.out.println("ATM hilang");
        System.out.println("Laporan Kehilangan ATM");
        switch (pilihMenulap) {
            case 1:
                System.out.println("1. Apakah anda ingin memblokir akun?");
                blokirAkun26E();
                break;
            case 2:
                System.out.println("2. Apakah anda ingin tutp akun?");
                tutupAkun26E();
                break;
            case 3:
                System.out.println("3. Ubah PIN");
                ubahPin26E();
            default:
                System.out.println("Input yang anda masukkkan salah!");
                break;
        }
    }

    static void ubahPin26E(){
        // Menampilkan Semua Data Nasabah
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("\t\t\t\t\t\t\t\tData Seluruh Nasabah");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("No Rekening" + "\t\tKTP" + "\t\tNama" + "\t\tPIN" + "\tSaldo" + "\t\tAlamat" + "\t\tNomer HP" + "\tJenis Tabungan" + "\t\tStatus");
        for (int i = 0; i < dataNasabah.length; i++) {
            System.out.print(dataNasabah[i][0]);
            System.out.print("\t\t" + dataNasabah[i][1]);
            System.out.print("\t" + dataNasabah[i][2]);
            System.out.print("\t\t" + dataNasabah[i][3]);
            System.out.print("\t" + dataNasabah2[i]);
            System.out.print("\t\t" + dataNasabah[i][4]);
            System.out.print("\t\t" + dataNasabah[i][5]);
            System.out.print("\t" + dataNasabah[i][6] + "\t");
            System.out.println("\t" + dataNasabah[i][7]);
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println();

        // Kode skip akun terblokir
        String status2 = null;
        System.out.println("\t\t\t\t\t\t\t\tData Yang Ingin Diubah");
        System.out.print("Masukkan Kata Kunci : ");
        String inputData = riska1.next();
        for (int i = 0; i < dataNasabah.length; i++) {
            for (int j = 0; j < dataNasabah[0].length; j++) {
                if (inputData.equalsIgnoreCase(dataNasabah[i][j])) {
                    p = i;
                    status2 = "Bisa";
                }
            }
        }
        // Filter akun terblokir
        if (dataNasabah[p][7].equalsIgnoreCase("Aktif")) {
            System.out.print("Masukkan PIN baru      : ");
                pin = riska.next();
                dataNasabah[p][3]=pin;
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("Akun Anda Sudah Berhasil di Ubah");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println();
                if (dataNasabah[p][7].equalsIgnoreCase("Aktif")) {
                    System.out.print("Masukkan PIN         : ");
                    pin = riska.next();
                    break;   
                }else{

                }
        }else{
            
        }
    }

    //1. Menambahkan Data Nasabah
    static void tambahData26E(){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("\tMenambahkan Data Nasabah");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
        System.out.print("Masukkan No Rekening : ");
        noRek = riska.next();
        System.out.print("Masukkkan No KTP     : ");
        ktp = riska.next();
        System.out.print("Masukkkan Nama       : ");
        nama = riska.next();
        System.out.print("Masukkan PIN         : ");
        pin = riska.next();
        System.out.print("Masukkan saldo       : ");
        saldoAwal = riska.nextInt();
        System.out.print("Masukkan alamat      : ");
        alamat = riska.next();
        System.out.print("Masukkan No HP       : ");
        noHP = riska.next();
        jenisTabungan = jenis26E();
        String status = "Aktif";
        int n = dataNasabah.length;
        String dataSementara[][] = new String[n+1][8];
        int dataSementara2[] = new int[n+1];
        for (int i = 0; i < n; i++) {
            dataSementara[i][0]=dataNasabah[i][0];
            dataSementara[i][1]=dataNasabah[i][1];
            dataSementara[i][2]=dataNasabah[i][2];
            dataSementara[i][3]=dataNasabah[i][3];
            dataSementara2[i]=dataNasabah2[i];
            dataSementara[i][4]=dataNasabah[i][4];
            dataSementara[i][5]=dataNasabah[i][5];
            dataSementara[i][6]=dataNasabah[i][6];
            dataSementara[i][7]=dataNasabah[i][7];
        }
        // Memasukkan data yang diinputkan kedalam array sementara
        dataSementara[n][0]=noRek;
        dataSementara[n][1]=ktp;
        dataSementara[n][2]=nama;
        dataSementara[n][3]=pin;
        dataSementara2[n]=saldoAwal;
        dataSementara[n][4]=alamat;
        dataSementara[n][5]=noHP;
        dataSementara[n][6]=jenisTabungan;
        dataSementara[n][7]=status;
        // Memasukkan data dari array sementara menuju dataNasabah
        dataNasabah = dataSementara;
        dataNasabah2 = dataSementara2;

        // Kode Membuat ATM
        String buat = "y";
        System.out.println();
        System.out.print("Apakah anda ingin membuat ATM (y/t): ");
        String buatATM = riska.next();
        if(buatATM.equalsIgnoreCase(buat)){
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("\t\tPembuatan ATM");
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println();
            System.out.println("\t\tREKENING");
            System.out.println();
            System.out.println("No Rekening : " + dataNasabah[(dataNasabah.length-1)][0]);
            System.out.println("Nama        : " + dataNasabah[(dataNasabah.length-1)][2]);
            System.out.println("Alamat      : " + dataNasabah[(dataNasabah.length-1)][4]);
            System.out.println("Telepon     : " + dataNasabah[(dataNasabah.length-1)][5]);
            System.out.println();
            System.out.println("\t\tKETERANGAN");
            System.out.println("----------------------------------------------------");
            System.out.println("\t\tSALDO\t\t" + dataNasabah2[dataNasabah2.length-1]);
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println();
        }else{
            System.out.println("Anda Tidak membuat Rekening ATM.");
        }
        //
        histori2[1]++;
    }

    //Menu pilihan jenis tabungan
    static String jenis26E(){
        System.out.println("Pilih jenis tabungan");
        System.out.println("1. Tabungan");
        System.out.println("2. Giro");
        System.out.println("3. Deposito");
        System.out.print("Pilih jenis tabungan [1/2/3] : ");
        opsiTabungan = riska.nextInt();
        switch (opsiTabungan) {
            case 1:
                jenisTabungan = "Tabungan";
                break;
            case 2:
                jenisTabungan = "Giro\t";
                break;
            case 3:
                jenisTabungan = "Deposito";
                break;
            default:
                System.out.println("Jenis Tabungan Tidak Ada!");
                break;
        }
        return jenisTabungan;
    }

    //2. Menampilkan Data Nasabah
    static void lihatData26E(){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("\t\tMenu Lihat Data Nasabah");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("1. Menampilkan Seluruh Data Nasabah");
        System.out.println("2. Menampilkan Data Nasabah yang terakhir dibuat");
        System.out.println("3. Menampilkan Data Tertentu");
        System.out.print("Masukkan Menu [1/2/3] : ");
        int pilihLihat = riska.nextInt();
        System.out.println();
        switch (pilihLihat) {
            case 1:
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("\t\t\t\t\t\t\t\tData Seluruh Nasabah");
                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                System.out.println("No Rekening" + "\t\tKTP" + "\t\tNama" + "\t\tPIN" + "\tSaldo" + "\t\tAlamat" + "\t\tNomer HP" + "\tJenis Tabungan" + "\t\tStatus");
                for (int i = 0; i < dataNasabah.length; i++) {
                    System.out.print(dataNasabah[i][0]);
                    System.out.print("\t\t" + dataNasabah[i][1]);
                    System.out.print("\t" + dataNasabah[i][2]);
                    System.out.print("\t\t" + dataNasabah[i][3]);
                    System.out.print("\t" + dataNasabah2[i]);
                    System.out.print("\t\t" + dataNasabah[i][4]);
                    System.out.print("\t\t" + dataNasabah[i][5]);
                    System.out.print("\t" + dataNasabah[i][6] + "\t");
                    System.out.println("\t" + dataNasabah[i][7]);
                }
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println();
                break;
            case 2:
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("\t\tData Yang Terakhir Dibuat");
                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
                System.out.println("No Rekening    : " + dataNasabah[(dataNasabah.length-1)][0]);
                System.out.println("No KTP         : " + dataNasabah[(dataNasabah.length-1)][1]);
                System.out.println("Nama           : " + dataNasabah[(dataNasabah.length-1)][2]);
                System.out.println("PIN            : " + dataNasabah[(dataNasabah.length-1)][3]);
                System.out.println("Alamat         : " + dataNasabah[(dataNasabah.length-1)][4]);
                System.out.println("Telepon        : " + dataNasabah[(dataNasabah.length-1)][5]);
                System.out.println("Jenis Tabungan : " + dataNasabah[(dataNasabah.length-1)][6]);
                System.out.println("Saldo          : " + dataNasabah2[dataNasabah2.length-1]);
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println();
                break;
            case 3:
                // Menampilkan seluruh data nasabah
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("\t\t\t\t\t\t\t\tData Seluruh Nasabah");
                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                System.out.println("No Rekening" + "\t\tKTP" + "\t\tNama" + "\t\tPIN" + "\tSaldo" + "\t\tAlamat" + "\t\tNomer HP" + "\tJenis Tabungan" + "\t\tStatus");
                for (int i = 0; i < dataNasabah.length; i++) {
                    System.out.print(dataNasabah[i][0]);
                    System.out.print("\t\t" + dataNasabah[i][1]);
                    System.out.print("\t" + dataNasabah[i][2]);
                    System.out.print("\t\t" + dataNasabah[i][3]);
                    System.out.print("\t" + dataNasabah2[i]);
                    System.out.print("\t\t" + dataNasabah[i][4]);
                    System.out.print("\t\t" + dataNasabah[i][5]);
                    System.out.print("\t" + dataNasabah[i][6] + "\t");
                    System.out.println("\t" + dataNasabah[i][7]);
                }
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println();
                // Kode Menampilkan Data yang dicari
                String status1 = "Bisa";
                System.out.print("Masukkan Kata Kunci : ");
                String inputData = riska3.nextLine();
                for (int i = 0; i < dataNasabah.length; i++) {
                    for (int j = 0; j < dataNasabah[0].length; j++) {
                        if (inputData.equalsIgnoreCase(dataNasabah[i][j])) {
                            p = i;
                            status1 = "Bisa";
                        }
                    }
                }
                if (status1.equalsIgnoreCase("bisa")) {
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    System.out.println("\t\t\t\t\t\tData Yang Anda Cari");
                    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                    System.out.println("No Rekening" + "\t\tKTP" + "\t\tNama" + "\t\tPIN" + "\tSaldo" + "\t\tAlamat" + "\t\tNomer HP" + "\tJenis Tabungan" + "\t\tStatus");
                    System.out.print(dataNasabah[p][0]);
                    System.out.print("\t\t" + dataNasabah[p][1]);
                    System.out.print("\t" + dataNasabah[p][2]);
                    System.out.print("\t\t" + dataNasabah[p][3]);
                    System.out.print("\t" + dataNasabah2[p]);
                    System.out.print("\t\t" + dataNasabah[p][4]);
                    System.out.print("\t\t" + dataNasabah[p][5]);
                    System.out.print("\t" + dataNasabah[p][6] + "\t");
                    System.out.println("\t" + dataNasabah[p][7]); 
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    System.out.println();
                } else{
                    System.out.println("Kata Kunci tidak terdata");
                }
                break;
            default:
                System.out.println("Input yang Anda masukkan Salah!");
                break;
        }
        histori2[2]++;
    }

    //3. Mengubah Data Nasabah
    static void ubahData26E(){
        // Menampilkan Semua Data Nasabah
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("\t\t\t\t\t\t\t\tData Seluruh Nasabah");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("No Rekening" + "\t\tKTP" + "\t\tNama" + "\t\tPIN" + "\tSaldo" + "\t\tAlamat" + "\t\tNomer HP" + "\tJenis Tabungan" + "\t\tStatus");
        for (int i = 0; i < dataNasabah.length; i++) {
            System.out.print(dataNasabah[i][0]);
            System.out.print("\t\t" + dataNasabah[i][1]);
            System.out.print("\t" + dataNasabah[i][2]);
            System.out.print("\t\t" + dataNasabah[i][3]);
            System.out.print("\t" + dataNasabah2[i]);
            System.out.print("\t\t" + dataNasabah[i][4]);
            System.out.print("\t\t" + dataNasabah[i][5]);
            System.out.print("\t" + dataNasabah[i][6] + "\t");
            System.out.println("\t" + dataNasabah[i][7]);
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println();

        // Kode skip akun terblokir
        String status1 = null;
        System.out.println("\t\t\t\t\t\t\t\tData Yang Ingin Diubah");
        System.out.print("Masukkan Kata Kunci : ");
        String inputData = riska1.next();
        for (int i = 0; i < dataNasabah.length; i++) {
            for (int j = 0; j < dataNasabah[0].length; j++) {
                if (inputData.equalsIgnoreCase(dataNasabah[i][j])) {
                    p = i;
                    status1 = "Bisa";
                }
            }
        }
        // Filter akun terblokir
        if (dataNasabah[p][7].equalsIgnoreCase("Aktif")) {


        //Menu
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("\t\tMenu Ubah Data Nasabah");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("1. Ubah No KTP");
        System.out.println("2. Ubah Nama");
        System.out.println("3. Ubah PIN");
        System.out.println("4. Ubah Alamat");
        System.out.println("5. Ubah No HP");
        System.out.println("6. Semua Data Nasabah");
        System.out.print("Masukkan Menu [1/2/3/4/5/6] : ");
        pilihMenu = riska2.nextInt();
        System.out.println();
        switch (pilihMenu) {
            case 1:
                System.out.print("Masukkkan No KTP     : ");
                ktp = riska.next();
                dataNasabah[p][1]=ktp;
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("Akun Anda Sudah Berhasil di Ubah");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println();
                break;
            case 2:
                System.out.print("Masukkkan Nama       : ");
                nama = riska.next();
                dataNasabah[p][2]=nama;
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("Akun Anda Sudah Berhasil di Ubah");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println();
                break;
            case 3:
                System.out.print("Masukkan PIN baru      : ");
                pin = riska.next();
                dataNasabah[p][3]=pin;
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("Akun Anda Sudah Berhasil di Ubah");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println();
                break;
            case 4:
                System.out.print("Masukkan alamat      : ");
                alamat = riska.next();
                dataNasabah[p][4]=alamat;
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("Akun Anda Sudah Berhasil di Ubah");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println();
                break;
            case 5:
                System.out.print("Masukkan No HP       : ");
                noHP = riska.next();
                dataNasabah[p][5]=noHP;
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("Akun Anda Sudah Berhasil di Ubah");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println();
                break;
            case 6:
                for (int i = 0; i < dataNasabah.length; i++) {
                    for (int j = 0; j < dataNasabah[0].length; j++) {
                        if (inputData.equalsIgnoreCase(dataNasabah[i][j])) {
                            dataNasabah[i][j] = "Bisa";
                            
                        }
                    }
                }
                if (dataNasabah[p][7].equalsIgnoreCase("Aktif")) {
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    System.out.println("\t\tMengubah Data Nasabah");
                    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
                    System.out.print("Masukkan No Rekening : ");
                    noRek = riska.next();
                    System.out.print("Masukkkan No KTP     : ");
                    ktp = riska.next();
                    System.out.print("Masukkkan Nama       : ");
                    nama = riska.next();
                    System.out.print("Masukkan PIN         : ");
                    pin = riska.next();
                    System.out.print("Masukkan saldo       : ");
                    saldoAwal = riska.nextInt();
                    System.out.print("Masukkan alamat      : ");
                    alamat = riska.next();
                    System.out.print("Masukkan No HP       : ");
                    noHP = riska.next();
                    jenisTabungan = jenis26E();
                    dataNasabah[p][0]=noRek;
                    dataNasabah[p][1]=ktp;
                    dataNasabah[p][2]=nama;
                    dataNasabah[p][3]=pin;
                    dataNasabah2[p]=saldoAwal;
                    dataNasabah[p][4]=alamat;
                    dataNasabah[p][5]=noHP;
                    dataNasabah[p][6]=jenisTabungan;
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    System.out.println("Akun Anda Sudah Berhasil di Ubah");
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    System.out.println();
                } 
                break;
            default:
                break;
        }
        histori2[3]++;
    }else {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Akun Sedang di Blokir");   
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println();
    }
    }

    //4. Mengecek Saldo PerNasabah
    static void cekSaldo26E(){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("\t\tMenu Lihat Saldo Nasabah");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("1. Menampilkan Seluruh Saldo Nasabah");
        System.out.println("2. Menampilkan Saldo Nasabah yang terakhir dibuat");
        System.out.println("3. Menampilkan Saldo Tertentu");
        System.out.print("Masukkan Menu [1/2/3] : ");
        int pilihSaldo = riska.nextInt();
        System.out.println();
        switch (pilihSaldo) {
            case 1:
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("\tSaldo Seluruh Nasabah");
                System.out.println("+++++++++++++++++++++++++++++++++++++");
                System.out.println("Nama" + "\tSaldo");
                for (int i = 0; i < dataNasabah.length; i++) {
                    System.out.print(dataNasabah[i][2] + "\t");
                    System.out.print(dataNasabah2[i]);
                    System.out.println();
                }
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                break;
            case 2:
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("\tSaldo Yang Terakhir Dibuat");
                System.out.println("+++++++++++++++++++++++++++++++++++++++++");
                System.out.println("Nama  : " + dataNasabah[(dataNasabah.length-1)][2]);
                System.out.println("Saldo : " + dataNasabah2[dataNasabah2.length-1]);
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println();
                break;
            case 3:
                // Menampilkan Semua Data Nasabah
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("\t\t\t\t\t\t\t\tData Seluruh Nasabah");
                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                System.out.println("No Rekening" + "\t\tKTP" + "\t\tNama" + "\t\tPIN" + "\tSaldo" + "\t\tAlamat" + "\t\tNomer HP" + "\tJenis Tabungan" + "\t\tStatus");
                for (int i = 0; i < dataNasabah.length; i++) {
                    System.out.print(dataNasabah[i][0]);
                    System.out.print("\t\t" + dataNasabah[i][1]);
                    System.out.print("\t" + dataNasabah[i][2]);
                    System.out.print("\t\t" + dataNasabah[i][3]);
                    System.out.print("\t" + dataNasabah2[i]);
                    System.out.print("\t\t" + dataNasabah[i][4]);
                    System.out.print("\t\t" + dataNasabah[i][5]);
                    System.out.print("\t" + dataNasabah[i][6] + "\t");
                    System.out.println("\t" + dataNasabah[i][7]);
                }
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println();

                String status1 = "Bisa";
                System.out.print("Masukkan Kata Kunci : ");
                String inputData = riska3.nextLine();
                for (int i = 0; i < dataNasabah.length; i++) {
                    for (int j = 0; j < dataNasabah[0].length; j++) {
                        if (inputData.equalsIgnoreCase(dataNasabah[i][j])) {
                            p = i;
                            status1 = "Bisa";
                        }
                    }
                }
                if (status1.equalsIgnoreCase("bisa")) {
                    System.out.println();
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    System.out.println("\t\tSaldo Yang Anda Cari");
                    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
                    System.out.println("Nama" + "\tSaldo");
                    System.out.print(dataNasabah[(dataNasabah.length-1)][2] + "\t");
                    System.out.print(dataNasabah2[0]+"\n");
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    System.out.println();
                    } else{
                        System.out.println("Kata Kunci tidak terdata");
                    }
                break;
            default:
                System.out.println("Input yang Anda Masukkan Salah!");
                break;
        }
        histori2[4]++;
    }
    
    //5. Tutup Akun Nasabah
    static void tutupAkun26E(){
        System.out.println("Sebelum Tutup Akun Silakan Kosongkan Saldo Terlebih Dahulu!");
        //Memilih menu Transfer atau Tarik
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("\t\tPilih Menu");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("1. Transfer Saldo");
        System.out.println("2. Tarik Saldo");
        System.out.print("Masukkan Menu [1/2/3] : ");
        int pilihMenuSaldo = riska1.nextInt();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println();
        switch (pilihMenuSaldo) {
            case 1:
                //Menampilkan Semua Data Nasabah
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("\t\t\t\t\t\t\t\tData Seluruh Nasabah");
                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                System.out.println("No Rekening" + "\t\tKTP" + "\t\tNama" + "\t\tPIN" + "\tSaldo" + "\t\tAlamat" + "\t\tNomer HP" + "\tJenis Tabungan" + "\t\tStatus");
                for (int i = 0; i < dataNasabah.length; i++) {
                    System.out.print(dataNasabah[i][0]);
                    System.out.print("\t\t" + dataNasabah[i][1]);
                    System.out.print("\t" + dataNasabah[i][2]);
                    System.out.print("\t\t" + dataNasabah[i][3]);
                    System.out.print("\t" + dataNasabah2[i]);
                    System.out.print("\t\t" + dataNasabah[i][4]);
                    System.out.print("\t\t" + dataNasabah[i][5]);
                    System.out.print("\t" + dataNasabah[i][6] + "\t");
                    System.out.println("\t" + dataNasabah[i][7]);
                }
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println();
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("\t\tTRANSFER SALDO");
                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
                System.out.print("Masukkan nomer rekening anda   : ");
                String inputRekening = riska3.nextLine();
                System.out.print("Masukkan nomor rekening tujuan : ");
                String rekeningTujuan = riska3.nextLine();
                for (int i = 0; i < dataNasabah.length; i++) {
                    if (inputRekening.equals(dataNasabah[i][0])) {
                        p=i;
                        int uangTransfer = dataNasabah2[i];
                        // Menunjukkan kode saat ini
                        System.out.println("Saldo anda saat ini            : " + dataNasabah2[i]);
                        // Saldo setelah mentransfer
                        int sisaSaldo = dataNasabah2[i] - uangTransfer;
                        System.out.println("Sisa Saldo anda                : " + sisaSaldo);
                    }
                }
                // Pencarian Rekening Tujuan
                for (int i = 0; i < dataNasabah.length; i++) {
                    if (rekeningTujuan.equals(dataNasabah[i][0])) {
                        int uangTransfer = dataNasabah2[i];
                        // Proses penambahan saldo rekening ke tujuan
                        int saldo = dataNasabah2[p] + uangTransfer;
                        System.out.println("Saldo " + dataNasabah[i][2] + " sekarang            : " + saldo);
                        // Deklarasi nilai akhir saldo
                        dataNasabah2[i] = saldo;
                    }
                }
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println();
                break;
            case 2:
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("\t\t\t\t\t\t\t\tData Seluruh Nasabah");
                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                System.out.println("No Rekening" + "\t\tKTP" + "\t\tNama" + "\t\tPIN" + "\tSaldo" + "\t\tAlamat" + "\t\tNomer HP" + "\tJenis Tabungan" + "\t\tStatus");
                for (int i = 0; i < dataNasabah.length; i++) {
                    System.out.print(dataNasabah[i][0]);
                    System.out.print("\t\t" + dataNasabah[i][1]);
                    System.out.print("\t" + dataNasabah[i][2]);
                    System.out.print("\t\t" + dataNasabah[i][3]);
                    System.out.print("\t" + dataNasabah2[i]);
                    System.out.print("\t\t" + dataNasabah[i][4]);
                    System.out.print("\t\t" + dataNasabah[i][5]);
                    System.out.print("\t" + dataNasabah[i][6] + "\t");
                    System.out.println("\t" + dataNasabah[i][7]);
                }
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println();
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("\t\tTARIK TUNAI");
                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
                System.out.print("Masukkan nomer rekening anda   : ");
                String inputNoRek = riska3.nextLine();
                for (int i = 0; i < dataNasabah.length; i++) {
                    if (inputNoRek.equals(dataNasabah[i][0])) {
                        // Menunjukkan kode saat ini
                        System.out.println("Saldo anda saat ini            : " + dataNasabah2[i]);
                        // Saldo setelah mentransfer
                        int sisaSaldo = dataNasabah2[i]*0;
                        System.out.println("Saldo " + dataNasabah[i][2] + " sekarang           : " + sisaSaldo);
                        // Deklarasi nilai akhir saldo
                        dataNasabah2[i]=dataNasabah2[i]-dataNasabah2[i];
                    }
                }
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println();
                break;
            default:
                System.out.println("Menu yang anda masukkan salah!");
                break;
        }
        //Kode Tutup Akun Nasabah
        String status1 = "nonaktif";
        System.out.print("Masukkan Kata Kunci Data Yang Akan di Tutup : ");
        String inputData = riska3.nextLine();
        for (int i = 0; i < dataNasabah.length; i++) {
            for (int j = 0; j < dataNasabah[0].length; j++) {
                if (inputData.equalsIgnoreCase(dataNasabah[i][j])) {
                    p = i;
                    status1 = "Bisa";
                }
            }
        }
        int n = dataNasabah.length;
        String dataSementara[][] = new String[n-1][8];
        int dataSementara2[] = new int[n-1];
        for (int i = 0; i < p; i++) {
            dataSementara[i][0]=dataNasabah[i][0];
            dataSementara[i][1]=dataNasabah[i][1];
            dataSementara[i][2]=dataNasabah[i][2];
            dataSementara[i][3]=dataNasabah[i][3];
            dataSementara2[i]=dataNasabah2[i];
            dataSementara[i][4]=dataNasabah[i][4];
            dataSementara[i][5]=dataNasabah[i][5];
            dataSementara[i][6]=dataNasabah[i][6];
            dataSementara[i][7]=dataNasabah[i][7];
        }
        for (int i = p+1; i <= dataSementara.length; i++) {
            dataSementara[i-1][0]=dataNasabah[i][0];
            dataSementara[i-1][1]=dataNasabah[i][1];
            dataSementara[i-1][2]=dataNasabah[i][2];
            dataSementara[i-1][3]=dataNasabah[i][3];
            dataSementara2[i-1]=dataNasabah2[i];
            dataSementara[i-1][4]=dataNasabah[i][4];
            dataSementara[i-1][5]=dataNasabah[i][5];
            dataSementara[i-1][6]=dataNasabah[i][6];
            dataSementara[i-1][7]=dataNasabah[i][7];
        }
        // Memasukkan data dari array sementara menuju dataNasabah
        dataNasabah = dataSementara;
        dataNasabah2 = dataSementara2;
        System.out.println("Data Berhasil di Tutup");
        histori2[5]++;
    }

    //6. Blokir Akun
    static void blokirAkun26E(){
        // Menampilkan Semua Data Nasabah
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("\t\t\t\t\t\t\t\tData Seluruh Nasabah");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("No Rekening" + "\t\tKTP" + "\t\tNama" + "\t\tPIN" + "\tSaldo" + "\t\tAlamat" + "\t\tNomer HP" + "\tJenis Tabungan" + "\t\tStatus");
        for (int i = 0; i < dataNasabah.length; i++) {
            System.out.print(dataNasabah[i][0]);
            System.out.print("\t\t" + dataNasabah[i][1]);
            System.out.print("\t" + dataNasabah[i][2]);
            System.out.print("\t\t" + dataNasabah[i][3]);
            System.out.print("\t" + dataNasabah2[i]);
            System.out.print("\t\t" + dataNasabah[i][4]);
            System.out.print("\t\t" + dataNasabah[i][5]);
            System.out.print("\t" + dataNasabah[i][6] + "\t");
            System.out.println("\t" + dataNasabah[i][7]);
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println();
        // Kode blokir Akun
        String status="nonaktif";
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Data Nasabah Yang Mau diblokir");
        System.out.println("++++++++++++++++++++++++++++++");
        System.out.print("Masukkan Kata Kunci : ");
        String inputData = riska2.nextLine();
        for (int i = 0; i < dataNasabah.length; i++) {
            for (int j = 0; j < dataNasabah[0].length; j++) {
                if (inputData.equalsIgnoreCase(dataNasabah[i][j])) {
                    p=i;
                    status="Bisa";
                    System.out.println("Data " + dataNasabah[i][j] + " berhasil di Blokir");
                }
            }
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        if (status.equalsIgnoreCase("Bisa")) {
            dataNasabah[p][7]="Blokir";
        } else{
            System.out.println("Kata Kunci tidak terdata");
        }
        histori2[6]++;
    }

    //7. Melihat Laporan Kegiatan CS
    //Lihat Data Nasabah Masuk dan Keluar (Mutasi Nasabah)
    static void tampilkanLaporanKegiatanCS26E(){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Histori" + "\t\t\tBerapa kali dilihat");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
        for (int i = 0; i < histori.length; i++) {
            if (histori2[i]==0) {
                continue;
            } else {
                System.out.println(histori[i]+"\t\t"+histori2[i]);
                
            }
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    

    public static void main( String [] args) {
    // Memanggil Fungsi Login CS
    loginCS26E();
    // Memanggil Fungsi Pemilihan Menu
        char ulang = 'y';
        char ulang1 = 'y';
        while (ulang==ulang1){
        menu26E();
            switch (pilihMenu) {
                case 1:
                    tambahData26E();
                    break;
                case 2:
                    lihatData26E();
                    break;
                case 3:
                    ubahData26E();
                    break;
                case 4:
                    cekSaldo26E();
                    break;
                case 5:
                    tutupAkun26E();
                    break;
                case 6:
                    blokirAkun26E(); 
                    break;
                case 7:
                    tampilkanLaporanKegiatanCS26E();  
                    break;
                case 8:
                    laporanKehilangan26E();
                default:
                    System.out.println("Menu yang anda masukkan salah!");
                    break;
            }
            System.out.print("Ingin memilih menu lain (y/t)? ");
            ulang = riska.next().charAt(0);
        }
        System.out.println("Terimakasih...");
    }
}