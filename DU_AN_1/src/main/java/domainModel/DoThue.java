/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodel;

import enumclass.trangThaiDoThue;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "DoThue")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class DoThue {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 36)
    private UUID id;
    private String maDoThue;
    private String tenDoThue;
    @ManyToOne
    @JoinColumn(name = "idKichThuoc")
    private KichThuoc kichThuoc;
    @ManyToOne
    @JoinColumn(name = "idMauSac")
    private MauSac mauSac;
    @ManyToOne
    @JoinColumn(name = "idNSX")
    private NhaSanXuat nhaSanXuat;
    private int soLuong;
    private double donGia;
    @Column(nullable = false)
    private trangThaiDoThue trangThai = trangThaiDoThue.Con_Hang;

}