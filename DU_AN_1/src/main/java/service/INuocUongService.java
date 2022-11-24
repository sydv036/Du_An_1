/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import java.util.UUID;
import modelview.QLNuocUong;

/**
 *
 * @author ASUS
 */
public interface INuocUongService {

    List<QLNuocUong> getNuocUong(int firstResult, int maxResults);

    List<QLNuocUong> getNuocUongNoPagination();

    UUID getNuocUongByName(String ten);

    String createNewNuocUong(QLNuocUong nuocUong);

    String updateNuocUongById(QLNuocUong nuocUong);

    String deleteNuocUongById(String id);

    long countAllNuocUong();
}
