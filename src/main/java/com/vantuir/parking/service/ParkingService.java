package com.vantuir.parking.service;

import com.vantuir.parking.exception.ParkingNotFoundException;
import com.vantuir.parking.model.Parking;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ParkingService {
    private static Map<String, Parking> parkingMap = new HashMap();

    static {
        var id0 = getUUID();
        var id1 = getUUID();
        var id2 = getUUID();

        Parking parking0 = new Parking(id0, "DMS-1111", "SC", "CELTA", "PRETO");
        Parking parking1 = new Parking(id1, "WAS-2222", "SP", "KWID", "VERMELHO");
        Parking parking2 = new Parking(id2, "FTE-3334", "SP", "FUSCA", "AZUL");
        parkingMap.put(id0, parking0);
        parkingMap.put(id1, parking1);
        parkingMap.put(id2, parking2);

    }

    public List<Parking> findAll() {

        return parkingMap.values().stream().collect(Collectors.toList());
    }

    private static String getUUID() {

        return UUID.randomUUID().toString().replace("-", "");
    }



    public Parking findById(String id) {
        Parking parking = parkingMap.get(id);
        if (parking==null) {
            throw new ParkingNotFoundException(id);
        }
        return parking;
    }



    public Parking create (Parking parkingCreate) {
        String uuid = getUUID();
        parkingCreate.setId(uuid);
        parkingCreate.setEntryDate(LocalDateTime.now());
        parkingMap.put(uuid, parkingCreate);
        return parkingCreate;
    }

    public void delete(String id) {
       findById(id);
       parkingMap.remove(id);
    }

    public Parking update(String id, Parking parkingCreate) {
        Parking parking = findById(id);
        parking.setColor(parkingCreate.getColor());
        parkingMap.replace(id,parking);
        return parking;
    }

    public Parking exit(String id) {

         return null;
    }
}
