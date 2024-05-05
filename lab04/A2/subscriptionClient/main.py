import grpc
import nba_stats_pb2
import nba_stats_pb2_grpc
import time

import grpc
import nba_stats_pb2
import nba_stats_pb2_grpc
import argparse
import time


def run(client_id, player_ids, seasons):
    channel = grpc.insecure_channel('localhost:50051')
    stub = nba_stats_pb2_grpc.NbaStatsStub(channel)

    player_ids_list = [int(id) for id in player_ids.split(',')]

    subscription = nba_stats_pb2.NbaStatsSubscription(
        clientId=int(client_id),
        playerIds=player_ids_list,
        seasons=seasons.split(',')
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
        run(client_id, player_ids, seasons)


def main():
    parser = argparse.ArgumentParser(description="NBA Stats gRPC Client")
    parser.add_argument("--client_id", type=str, required=True, help="Client ID")
    parser.add_argument("--player_ids", type=str, required=True,
                        help="Comma-separated list of player IDs (e.g., '1,2,3')")
    parser.add_argument("--seasons", type=str, required=True,
                        help="Comma-separated list of seasons (e.g., '2020-2021,2021-2022')")

    args = parser.parse_args()

    run(args.client_id, args.player_ids, args.seasons)


if __name__ == '__main__':
    main()
