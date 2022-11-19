package modelview;

import enumclass.trangThaiPhuPhi;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class QLPhuPhi {

    private UUID id;

    private String maPhuPhi;

    private String tenPhuPhi;

    private double giaPhuPhi;

    private String moTa;

    private trangThaiPhuPhi trangThai = trangThaiPhuPhi.Co;

    public QLPhuPhi(UUID id) {
        this.id = id;
    }
    
    
}
