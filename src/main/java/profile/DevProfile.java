package profile;

import java.util.ArrayList;
import java.util.List;

public class DevProfile implements SystemProfile {
    @Override
    public String getProfile() {
        return "Current profile is dev";
    }
}
