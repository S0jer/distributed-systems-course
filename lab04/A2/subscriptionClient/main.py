import grpc
import nba_stats_pb2
import nba_stats_pb2_grpc
import time


def run():
    channel = grpc.insecure_channel('localhost:50051')
    stub = nba_stats_pb2_grpc.NbaStatsStub(channel)

    subscription = nba_stats_pb2.NbaStatsSubscription(
        playerId=201939,
        seasons=["2022-2023", "2021-2022", "2020-2021"]
    )

    try:
        responses = stub.SubscribeNbaStats(subscription)
        for response in responses:
            print("Received Update for Player ID:", response.playerId)
            for game in response.games:
                print(f"Game ID: {game.gameId}, Date: {game.date}, Opponent: {game.opponent}")
                print(f"Outcome: {nba_stats_pb2.GameOutcome.Name(game.outcome)}, Points: {game.stats.points}")
                print("Detailed Stats:", game.stats)

    except grpc.RpcError as e:
        print("RPC failed: {status_code}".format(status_code=e.code()))
        print('Waiting for connection...')
        time.sleep(5)
        run()


if __name__ == '__main__':
    run()
