package com.zzz.testweb.system.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class Compress {
    private static final int BUFFER_LENGTH = 400;
    
    
    //鍘嬬缉瀛楄妭鏈�灏忛暱搴︼紝灏忎簬杩欎釜闀垮害鐨勫瓧鑺傛暟缁勪笉閫傚悎鍘嬬缉锛屽帇缂╁畬浼氭洿澶�
    public static final int BYTE_MIN_LENGTH = 50;
    
    
    //瀛楄妭鏁扮粍鏄惁鍘嬬缉鏍囧織浣�
    public static final byte FLAG_GBK_STRING_UNCOMPRESSED_BYTEARRAY = 0;
    public static final byte FLAG_GBK_STRING_COMPRESSED_BYTEARRAY = 1;
    public static final byte FLAG_UTF8_STRING_COMPRESSED_BYTEARRAY = 2;
    public static final byte FLAG_NO_UPDATE_INFO = 3;
    
    /**  
     * 鏁版嵁鍘嬬缉  
     *   
     * @param is  
     * @param os  
     * @throws Exception  
     */  
    public static void compress(InputStream is, OutputStream os)   
            throws Exception {   
  
        GZIPOutputStream gos = new GZIPOutputStream(os);   
  
        int count;   
        byte data[] = new byte[BUFFER_LENGTH];   
        while ((count = is.read(data, 0, BUFFER_LENGTH)) != -1) {   
            gos.write(data, 0, count);   
        }   
  
        gos.finish();   
  
        gos.flush();   
        gos.close();   
    }   
    
    
    /**  
     * 鏁版嵁瑙ｅ帇缂�  
     *   
     * @param is  
     * @param os  
     * @throws Exception  
     */  
    public static void decompress(InputStream is, OutputStream os)   
            throws Exception {   
  
        GZIPInputStream gis = new GZIPInputStream(is);   
  
        int count;   
        byte data[] = new byte[BUFFER_LENGTH];   
        while ((count = gis.read(data, 0, BUFFER_LENGTH)) != -1) {   
            os.write(data, 0, count);   
        }   
  
        gis.close();   
    } 
    
    /** 
     * 鏁版嵁鍘嬬缉 
     *  
     * @param data 
     * @return 
     * @throws Exception 
     */  
    public static byte[] byteCompress(byte[] data) throws Exception {  
        ByteArrayInputStream bais = new ByteArrayInputStream(data);  
        ByteArrayOutputStream baos = new ByteArrayOutputStream();  
  
        // 鍘嬬缉  
        compress(bais, baos);  
  
        byte[] output = baos.toByteArray();  
  
        baos.flush();  
        baos.close();  
  
        bais.close();  
  
        return output;  
    } 
    
    
    /** 
     * 鏁版嵁瑙ｅ帇缂� 
     *  
     * @param data 
     * @return 
     * @throws Exception 
     */  
    public static byte[] byteDecompress(byte[] data) throws Exception {  
        ByteArrayInputStream bais = new ByteArrayInputStream(data);  
        ByteArrayOutputStream baos = new ByteArrayOutputStream();  
  
        // 瑙ｅ帇缂�  
  
        decompress(bais, baos);  
  
        data = baos.toByteArray();  
  
        baos.flush();  
        baos.close();  
  
        bais.close();  
  
        return data;  
    }  
    
    
	public static void main(String[] args) throws Exception {
        String Code = "h8sXZQeQ_GDJG6A-iCUthcQEDraQi61Qm4iwohYgIgjyOm5nvDGtTb0ONLZ- kpZSX6sx82-_zx-Vbrf2z9Vv5ZKbAHzz5pUXG4ISVHOmvtqNog6vRg7-5Qu_ u69u9GKFoEhBh2sATXK3Q3j1mhgiJ5COBi7kF5B_CsZPg-wqtTOap3YwYEVE NWz5lQDbVIZjLn8l-o8JdyQNa8pkm0zu6vUMkj0lnYUQRDFQ321N_KTykZc1 OworslSHOgoNP4gcu8V2EKXlvTtD-vuXi3RM0KhtIiDM8ZX70MgZlzEuZiet biQDIR0esQl0JwigzGIJnUq4eefde4gYv12_qcXEs_LcrN-ewH1RNWnywL_a dbEATO_8OxLfbohedMhlMGVHMSzw26rAUiIkxXjiPVYGKIgaU53cXFlD1vne kYRk5VMaVOjt__j0YWunzPmx4aBeONrsYiR5FD91cwHIr4CMhMmZpDeAEY6_ ZwAU5NWoe9UATO_8OxLfbohedMhlMGVHpYWIWn3OFG4DPn8gkjGyGZA9Fgul K7o8s4trGOhy3UGL-GuNApgYamD5RVjpExfcsvBI-7ZI-itYgJbGRDSNo0qM xUS9tJW-C9hJgwxnlBnA6vs7k99c5uK-ZO_8tzv5hHN5jghl_0Go3jH1dAhx A3RPoO5zCQt3vIjJe1P6o8Twrf8TEOV_ZZOX_Hp5OVcf0jDEaqq3brWlyEHy hpszrcETpBPbwcVPD0Jn5x-3AK42hJJQNduj1EtPHM9RJLef27BE5KYFOsor d7hj_uzJ-yrJqb3BIlITSdB4a06yzK8b7nbOMl7D9KKRAco0_S9nBmeuILms y6pb_uh9Jj5H7nKCFenZFbxWwttiQpwGqCt6so9pTwHhfnhTN2_Bts8CTDuU 8GplXdM0PUL4YDzgXAip7yx2rVh6b-2VbA53nT2Dh_iWHOB2LnxhTIpars09 b_SVlXRBiiydLA7BYxEXQgTjPFPvjLvXLxYeU5EVulK3o_CuxCy-X9QPghZK Up9DSw68YuorOGZgvxRoACqzImjSyd4YYpOO-UTNPX2BO-WaeD-W8-Eyt4o3 ylLsMMFPh_LMRTjegOUtAS2sgGq1KpawkPXTYQPfri5I1Q_KIgXSqLisowZv D7CILu8jXk7JL8H428n7LhuLWqUPEqUR0qAngUOXiwTVO3ckPx03GH5I1dFj dpkuY84jEjqAJVcwbOI9D7PPeLPVisb4TjWK9iON1jTLEcgKKsreFpKApo45 aOA5tG_Ex_6_7Rh-n9bSLEQ4h6UNX2nrPWAuxc2v_700If0tU90Qjd0xen7H rTn7R3qVc9a6Nb1LGm0pLiCeTTPj41CtPzjIawezMM5e2E_W9DW41UzpSXX8 EyvZ8HL7R3qVc9a6Nb1LGm0pLiCe6VvmzyZSo1cHwMmc5W_lRvJPdzA76yG4 8ZXaXGoy1DVWpiA5-XB4JtZQoit9PubmxFj6vzJ8L3Jkpt1byRaSBDxpkjHY gbebe2tUeopT-jTOVdVYiQ4QEH8vFqW9PAR9HzrsVVoJNLdeWA9MAe3ux-RR VCIwSx-g8BeOxR10NZmuX1mMFtonc3uWuFOnj9iKNXymI3PkRoM80kiAW4y6 DXjw6DHPhUbEK-sPkTrNDKZ5tD9gnQuKSTxmWaPC6nHPU8QorsFi4IftPfhM GLvx2zPzJ2vaOm2emVpfFboYWQ74_TwkRzr_phnk1iBhg1ibFRK9UBbUoxpo v8G25QV0GUaloSQHER6lcRCQATobyTUWwmIPocGYbsmkx96LUszn2KGDqwUT BxgjTax8hysatITPhiECKO8KTjW5YMtXXyFNXi949psdH9FuvSEJOFLuP6rN 56i35_xV9txM6bJpjr6nX1uObuWjPQ0BnhfacjHzBjGq9ybdM4LTYjvy1zIF RQ1oS_7sRKNb4rHDLDV1GQm9Cc3B5cGy4hgSbM49rbVeAdr2nr6bHAiPJMH7 uCeNG7eKdx_H82lSQV_tr_d2VllVeKRR-wiCLopT2bGbE2qkOaRwmHu0p3o6 _5KvFgDJ6sSwcVUxKjPU9rDLIzEiry31GUYDyoLLfOZT69RWzVn756kJ8Wtr LlBxB8e-6-WABvmPOeRYd5X9OjKolf51VcN2XTPpEqSTF7xseO_TB9V0y1-n SaXx7qk-9P_uuB68N6LyrWiWKFEav3SBfxeyh5Mh33Dpy7X6mUYZL2FobOHB 1KVNGKHzJwjUHNbtCJ-raZwiKNBSpqiNkL82m86K1QVCFj6mjvEAwCzTSF9A r8goJOMMS2X-AIHnTOuJp7lRJtr0D1oDcsP6TSHwxWTent2gLxBz2ckj5hzr ElyG0nghThZvFas-nHYRfo7nsBZ_a1t0cwKAnQyL6zgbG99Yy0LQ7YkuvLgc r1UYfKuIRSZd_-Nj5wmBuyJrtM5p-eqD27BE5KYFOsord7hj_uzJ-2cxIM15 xgRMtzZDBm99VJ3-0iAXrlzNsW7PlugN1QDQxzG-bFixEzYLZkmum2SDVjea bUDt9nNFcSsjymDjrYY=";
        // {"ERRORCODE":"0","ERRORMSG":"鎵ц鎴愬姛","ResultContent":"h8sXZQeQ_GDJG6A-iCUthcQEDraQi61Qm4iwohYgIgjyOm5nvDGtTb0ONLZ- kpZSX6sx82-_zx-Vbrf2z9Vv5ZKbAHzz5pUXG4ISVHOmvtqNog6vRg7-5Qu_ u69u9GKFoEhBh2sATXK3Q3j1mhgiJ5COBi7kF5B_CsZPg-wqtTOap3YwYEVE NWz5lQDbVIZjLn8l-o8JdyQNa8pkm0zu6vUMkj0lnYUQRDFQ321N_KTykZc1 OworslSHOgoNP4gcu8V2EKXlvTtD-vuXi3RM0KhtIiDM8ZX70MgZlzEuZiet biQDIR0esQl0JwigzGIJnUq4eefde4gYv12_qcXEs_LcrN-ewH1RNWnywL_a dbEATO_8OxLfbohedMhlMGVHMSzw26rAUiIkxXjiPVYGKIgaU53cXFlD1vne kYRk5VMaVOjt__j0YWunzPmx4aBeONrsYiR5FD91cwHIr4CMhMmZpDeAEY6_ ZwAU5NWoe9UATO_8OxLfbohedMhlMGVHpYWIWn3OFG4DPn8gkjGyGZA9Fgul K7o8s4trGOhy3UGL-GuNApgYamD5RVjpExfcsvBI-7ZI-itYgJbGRDSNo0qM xUS9tJW-C9hJgwxnlBnA6vs7k99c5uK-ZO_8tzv5hHN5jghl_0Go3jH1dAhx A3RPoO5zCQt3vIjJe1P6o8Twrf8TEOV_ZZOX_Hp5OVcf0jDEaqq3brWlyEHy hpszrcETpBPbwcVPD0Jn5x-3AK42hJJQNduj1EtPHM9RJLef27BE5KYFOsor d7hj_uzJ-yrJqb3BIlITSdB4a06yzK8b7nbOMl7D9KKRAco0_S9nBmeuILms y6pb_uh9Jj5H7nKCFenZFbxWwttiQpwGqCt6so9pTwHhfnhTN2_Bts8CTDuU 8GplXdM0PUL4YDzgXAip7yx2rVh6b-2VbA53nT2Dh_iWHOB2LnxhTIpars09 b_SVlXRBiiydLA7BYxEXQgTjPFPvjLvXLxYeU5EVulK3o_CuxCy-X9QPghZK Up9DSw68YuorOGZgvxRoACqzImjSyd4YYpOO-UTNPX2BO-WaeD-W8-Eyt4o3 ylLsMMFPh_LMRTjegOUtAS2sgGq1KpawkPXTYQPfri5I1Q_KIgXSqLisowZv D7CILu8jXk7JL8H428n7LhuLWqUPEqUR0qAngUOXiwTVO3ckPx03GH5I1dFj dpkuY84jEjqAJVcwbOI9D7PPeLPVisb4TjWK9iON1jTLEcgKKsreFpKApo45 aOA5tG_Ex_6_7Rh-n9bSLEQ4h6UNX2nrPWAuxc2v_700If0tU90Qjd0xen7H rTn7R3qVc9a6Nb1LGm0pLiCeTTPj41CtPzjIawezMM5e2E_W9DW41UzpSXX8 EyvZ8HL7R3qVc9a6Nb1LGm0pLiCe6VvmzyZSo1cHwMmc5W_lRvJPdzA76yG4 8ZXaXGoy1DVWpiA5-XB4JtZQoit9PubmxFj6vzJ8L3Jkpt1byRaSBDxpkjHY gbebe2tUeopT-jTOVdVYiQ4QEH8vFqW9PAR9HzrsVVoJNLdeWA9MAe3ux-RR VCIwSx-g8BeOxR10NZmuX1mMFtonc3uWuFOnj9iKNXymI3PkRoM80kiAW4y6 DXjw6DHPhUbEK-sPkTrNDKZ5tD9gnQuKSTxmWaPC6nHPU8QorsFi4IftPfhM GLvx2zPzJ2vaOm2emVpfFboYWQ74_TwkRzr_phnk1iBhg1ibFRK9UBbUoxpo v8G25QV0GUaloSQHER6lcRCQATobyTUWwmIPocGYbsmkx96LUszn2KGDqwUT BxgjTax8hysatITPhiECKO8KTjW5YMtXXyFNXi949psdH9FuvSEJOFLuP6rN 56i35_xV9txM6bJpjr6nX1uObuWjPQ0BnhfacjHzBjGq9ybdM4LTYjvy1zIF RQ1oS_7sRKNb4rHDLDV1GQm9Cc3B5cGy4hgSbM49rbVeAdr2nr6bHAiPJMH7 uCeNG7eKdx_H82lSQV_tr_d2VllVeKRR-wiCLopT2bGbE2qkOaRwmHu0p3o6 _5KvFgDJ6sSwcVUxKjPU9rDLIzEiry31GUYDyoLLfOZT69RWzVn756kJ8Wtr LlBxB8e-6-WABvmPOeRYd5X9OjKolf51VcN2XTPpEqSTF7xseO_TB9V0y1-n SaXx7qk-9P_uuB68N6LyrWiWKFEav3SBfxeyh5Mh33Dpy7X6mUYZL2FobOHB 1KVNGKHzJwjUHNbtCJ-raZwiKNBSpqiNkL82m86K1QVCFj6mjvEAwCzTSF9A r8goJOMMS2X-AIHnTOuJp7lRJtr0D1oDcsP6TSHwxWTent2gLxBz2ckj5hzr ElyG0nghThZvFas-nHYRfo7nsBZ_a1t0cwKAnQyL6zgbG99Yy0LQ7YkuvLgc r1UYfKuIRSZd_-Nj5wmBuyJrtM5p-eqD27BE5KYFOsord7hj_uzJ-2cxIM15 xgRMtzZDBm99VJ3-0iAXrlzNsW7PlugN1QDQxzG-bFixEzYLZkmum2SDVjea bUDt9nNFcSsjymDjrYY="}
        
        byte[] byteCode = byteCompress(Code.getBytes());
        
        String strRtnCode = new String(byteDecompress(byteCode));

        System.out.println("鍘�       鏂囷細" + Code);
        System.out.println("鍔犺В瀵嗘枃锛�" + strRtnCode);


    }
}