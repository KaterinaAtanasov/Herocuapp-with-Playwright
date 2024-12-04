package dataproviders;

import org.testng.annotations.DataProvider;

public class KeysProvider {
    @DataProvider
    public static Object[][] pressKeysProvider() {
        Object[][] dataset = new Object[7][2];

        dataset[0][0] = "A";
        dataset[0][1] = "A";

        dataset[1][0] = "1";
        dataset[1][1] = "1";

        dataset[2][0] = "Space";
        dataset[2][1] = "SPACE";

        dataset[3][0] = "Enter";
        dataset[3][1] = "ENTER";

        dataset[4][0] = "Tab";
        dataset[4][1] = "TAB";

        dataset[5][0] = "Comma";
        dataset[5][1] = "COMMA";

        dataset[6][0] = "Win";
        dataset[6][1] = "WIN";

        return dataset;
    }
}
