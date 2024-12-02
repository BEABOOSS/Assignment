package model;

public enum States {
    SELECT_STATE("Select State"),
    ALBERTA("Alberta"),
    BRITISH_COLUMBIA("British Columbia"),
    MANITOBA("Manitoba"),
    NEW_BRUNSWICK("New Brunswick"),
    NEWFOUNDLAND_AND_LABRADOR("Newfoundland and Labrador"),
    NOVA_SCOTIA("Nova Scotia"),
    ONTARIO("Ontario"),
    PRINCE_EDWARD_ISLAND("Prince Edward Island"),
    QUEBEC("Quebec"),
    SASKATCHEWAN("Saskatchewan"),
    YUKON("Yukon"),
    NUNAVUT("Nunavut"),
    NORTHWEST_TERRITORIES("Northwest Territories");

    private final String displayName;

    States(String displayName) {
        this.displayName = displayName;
    }

    public static String getName(String dis){
        for (States state: States.values()){
            if (state.getDisplayName().equals(dis)){
                return state.name();
            }
        }

        return States.SELECT_STATE.name();
    }


    public String getDisplayName() {
        return displayName;
    }
}
