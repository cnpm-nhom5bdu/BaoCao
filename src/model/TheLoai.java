/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Tuong Nguyen
 */
public class TheLoai {
    private int maTheLoai;
    private String tenTheloai;

    public TheLoai(int maTheLoai, String tenTheloai) {
        this.maTheLoai = maTheLoai;
        this.tenTheloai = tenTheloai;
    }

    public TheLoai() {
    }

    public int getMaTheLoai() {
        return maTheLoai;
    }

    public void setMaTheLoai(int maTheLoai) {
        this.maTheLoai = maTheLoai;
    }

    public String getTenTheloai() {
        return tenTheloai;
    }

    public void setTenTheloai(String tenTheloai) {
        this.tenTheloai = tenTheloai;
    }
    
}
