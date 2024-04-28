module actions {
    interface Booster {
        // Holds state and is used frequently, singleton servant
        int boostAndReturn(int number);
    };

    interface Database {
        // Holds state and is used infrequently, lazy instantiation of servant
        void toUpperCaseAndSave(string info);
    };

    interface Subtractor {
        // Stateless and used frequently, shared servant
        idempotent int subtract(int fundamental, int retracent);
    };
};
