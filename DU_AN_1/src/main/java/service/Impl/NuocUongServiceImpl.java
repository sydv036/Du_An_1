/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.Impl;

import domainmodel.NuocUong;
import enumclass.trangThaiNuocUong;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import modelview.QLNuocUong;
import repository.INuocUongRepository;
import repository.impl.NuocUongRepositoryImpl;
import service.INuocUongService;

public class NuocUongServiceImpl implements INuocUongService {

    private INuocUongRepository nuocUongRepositoryImpl = new NuocUongRepositoryImpl();
    private Map<String, Object> map = new HashMap<>();

    @Override
    public List<QLNuocUong> getNuocUong(int firstResult, int maxResults) {
        List<NuocUong> listNuocUong = nuocUongRepositoryImpl.fillAll(firstResult, maxResults);

        List<QLNuocUong> listQLNuocUong = new ArrayList<>();

        for (NuocUong x : listNuocUong) {
            //id, maNuocUong, tenNuocUong, soLuong, gia, trangThai
            listQLNuocUong.add(
                    new QLNuocUong(
                            x.getId(),
                            x.getMaNuocUong(),
                            x.getTenNuocUong(),
                            x.getSoLuong(),
                            x.getGia(),
                            x.getTrangThai()
                    )
            );
        }

        return listQLNuocUong;
    }

    @Override
    public String createNewNuocUong(QLNuocUong nuocUong) {
        if (map.containsKey(nuocUong.getMaNuocUong())) {
            return "Mã trùng";
        }

        if (map.containsKey(nuocUong.getTenNuocUong())) {
            return "Tên Nước trùng";
        }
        nuocUong.setId(null);
        boolean save = nuocUongRepositoryImpl.saveOrUpdate(
                new NuocUong(
                        nuocUong.getId(),
                        nuocUong.getMaNuocUong(),
                        nuocUong.getTenNuocUong(),
                        nuocUong.getSoLuong(),
                        nuocUong.getGia(),
                        nuocUong.getTrangThai()
                )
        );
        if (save) {
            return "Tạo mới Nước Uống Thành Công";
        } else {
            return "Tạo mới Nước Uống Không Công";
        }
    }

    @Override
    public String updateNuocUongById(QLNuocUong nuocUong) {
        boolean save = nuocUongRepositoryImpl.saveOrUpdate(
                new NuocUong(nuocUong.getId(),
                        nuocUong.getMaNuocUong(),
                        nuocUong.getTenNuocUong(),
                        nuocUong.getSoLuong(),
                        nuocUong.getGia(),
                        nuocUong.getTrangThai()
                )
        );
        if (save) {
            return "Cập Nhập Nước Uống Thành Công";
        } else {
            return "Cập Nhập Nước Uống Không Công";
        }
    }

    @Override
    public String deleteNuocUongById(String id) {
        boolean delete = nuocUongRepositoryImpl.delete(id);
        if (delete) {
            return "Xóa Nước Uống Thành Công";
        } else {
            return "Xóa Nước Uống Không Công";
        }
    }

    @Override
    public long countAllNuocUong() {
        return nuocUongRepositoryImpl.totalCount();

    }

    @Override
    public List<QLNuocUong> getNuocUongNoPagination() {
        List<NuocUong> listNuocUong = nuocUongRepositoryImpl.fillAllNuocUong();

        List<QLNuocUong> listQLNuocUong = new ArrayList<>();

        for (NuocUong x : listNuocUong) {
            map.put(x.getMaNuocUong(), x);
            map.put(x.getTenNuocUong(), x);
            //id, maNuocUong, tenNuocUong, soLuong, gia, trangThai
            listQLNuocUong.add(
                    new QLNuocUong(
                            x.getId(),
                            x.getMaNuocUong(),
                            x.getTenNuocUong(),
                            x.getSoLuong(),
                            x.getGia(),
                            x.getTrangThai()
                    )
            );
        }

        return listQLNuocUong;
    }

    @Override
    public String getNuocUongByName(String ten) {
        return nuocUongRepositoryImpl.fillByName(ten);
    }

    @Override
    public List<QLNuocUong> getNuocUongByTenNuocUong(String tenNuocUong) {
        List<NuocUong> listNuocUong = nuocUongRepositoryImpl.findByTenNuocUong(tenNuocUong);
        List<QLNuocUong> listQLNuocUong = new ArrayList<>();
        for (NuocUong nuocUong : listNuocUong) {
            listQLNuocUong.add(
                    new QLNuocUong(
                            nuocUong.getId(),
                            nuocUong.getMaNuocUong(),
                            nuocUong.getTenNuocUong(),
                            nuocUong.getSoLuong(),
                            nuocUong.getGia(),
                            nuocUong.getTrangThai()));
        }
        return listQLNuocUong;
    }

    @Override
    public List<QLNuocUong> getNuocUongByTranThai(String trangThai) {
        List<NuocUong> listNuocUong = nuocUongRepositoryImpl.findByTrangThai(trangThai);
        List<QLNuocUong> listQLNuocUong = new ArrayList<>();
        for (NuocUong nuocUong : listNuocUong) {
            listQLNuocUong.add(
                    new QLNuocUong(
                            nuocUong.getId(),
                            nuocUong.getMaNuocUong(),
                            nuocUong.getTenNuocUong(),
                            nuocUong.getSoLuong(),
                            nuocUong.getGia(),
                            nuocUong.getTrangThai()));
        }
        return listQLNuocUong;
    }
}
