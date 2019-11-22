package by.artezio;

import by.artezio.entity.ApplicationUser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public interface TestSampleData {

    ApplicationUser user = new ApplicationUser(
                    "testName",
                    "testLogin",
                    "testPassword",
                    "test@email.ru",
            Collections.emptySet(),
            Collections.emptySet());

    }
