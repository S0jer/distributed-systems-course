// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: nba_stats.proto

// Protobuf Java Version: 4.26.1
package org.agh.edu.pl.gen;

public interface PlayerStatisticsResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:PlayerStatisticsResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string playerId = 1;</code>
   * @return The playerId.
   */
  java.lang.String getPlayerId();
  /**
   * <code>string playerId = 1;</code>
   * @return The bytes for playerId.
   */
  com.google.protobuf.ByteString
      getPlayerIdBytes();

  /**
   * <code>repeated .GameStatistics games = 2;</code>
   */
  java.util.List<GameStatistics>
      getGamesList();
  /**
   * <code>repeated .GameStatistics games = 2;</code>
   */
  GameStatistics getGames(int index);
  /**
   * <code>repeated .GameStatistics games = 2;</code>
   */
  int getGamesCount();
  /**
   * <code>repeated .GameStatistics games = 2;</code>
   */
  java.util.List<? extends GameStatisticsOrBuilder>
      getGamesOrBuilderList();
  /**
   * <code>repeated .GameStatistics games = 2;</code>
   */
  GameStatisticsOrBuilder getGamesOrBuilder(
      int index);
}