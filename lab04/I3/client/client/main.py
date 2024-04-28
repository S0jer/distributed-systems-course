import Ice
import actions
import sys


def stop(communicator):
    communicator.destroy()
    sys.exit()


def client():
    communicator = Ice.initialize(sys.argv)
    endpoints = "tcp -h 127.0.0.2 -p 10000 -z : udp -h 127.0.0.2 -p 10000 -z"
    print("Connection endpoints:", endpoints)

    while True:
        action = input("action: ")
        params = action.split()
        action_type = params[0]

        if action_type == "booster" and len(params) == 2:
            proxy = communicator.stringToProxy(f"booster:{endpoints}")
            booster = actions.BoosterPrx.checkedCast(proxy)
            if not booster:
                print("Invalid proxy for booster!")
                stop(communicator)
            number = booster.boostAndReturn(int(params[1]))
            print("Boosted value:", number)

        elif action_type == "database" and len(params) == 2:
            proxy = communicator.stringToProxy(f"database:{endpoints}")
            database = actions.DatabasePrx.checkedCast(proxy)
            if not database:
                print("Invalid proxy for database!")
                stop(communicator)
            database.toUpperCaseAndSave(params[1])

        elif action_type == "subtractor" and len(params) == 3:
            proxy = communicator.stringToProxy(f"subtractor:{endpoints}")
            subtractor = actions.SubtractorPrx.checkedCast(proxy)
            if not subtractor:
                print("Invalid proxy for subtractor!")
                stop(communicator)
            result = subtractor.subtract(int(params[1]), int(params[2]))
            print("Result:", result)

        else:
            print("Invalid command or incorrect number of arguments.")


if __name__ == "__main__":
    client()
