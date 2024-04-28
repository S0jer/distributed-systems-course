// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: nba_stats.proto
// Protobuf Java Version: 4.26.1

package org.agh.edu.pl.gen;

public final class NbaStatsProto {
  private NbaStatsProto() {}
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 26,
      /* patch= */ 1,
      /* suffix= */ "",
      NbaStatsProto.class.getName());
  }
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_NbaStatsSubscription_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_NbaStatsSubscription_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_SeasonAveragesRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_SeasonAveragesRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_PlayerStatisticsResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_PlayerStatisticsResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_SeasonAveragesResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_SeasonAveragesResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_SeasonStatistics_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_SeasonStatistics_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_GameStatistics_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_GameStatistics_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_DetailedStatistics_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_DetailedStatistics_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_FieldGoalStats_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_FieldGoalStats_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_FreeThrowStats_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_FreeThrowStats_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\017nba_stats.proto\"9\n\024NbaStatsSubscriptio" +
      "n\022\020\n\010playerId\030\001 \001(\005\022\017\n\007seasons\030\002 \003(\t\"9\n\025" +
      "SeasonAveragesRequest\022\020\n\010playerId\030\001 \001(\005\022" +
      "\016\n\006season\030\002 \001(\t\"L\n\030PlayerStatisticsRespo" +
      "nse\022\020\n\010playerId\030\001 \001(\t\022\036\n\005games\030\002 \003(\0132\017.G" +
      "ameStatistics\"=\n\026SeasonAveragesResponse\022" +
      "#\n\010averages\030\001 \001(\0132\021.SeasonStatistics\"M\n\020" +
      "SeasonStatistics\022\016\n\006season\030\001 \001(\t\022)\n\014aver" +
      "ageStats\030\002 \001(\0132\023.DetailedStatistics\"\263\001\n\016" +
      "GameStatistics\022\016\n\006gameId\030\001 \001(\t\022\014\n\004date\030\002" +
      " \001(\t\022\020\n\010opponent\030\003 \001(\t\022\035\n\007outcome\030\004 \001(\0162" +
      "\014.GameOutcome\022.\n\024gamePerformanceGrade\030\005 " +
      "\001(\0162\020.GamePerformance\022\"\n\005stats\030\006 \001(\0132\023.D" +
      "etailedStatistics\"\224\002\n\022DetailedStatistics" +
      "\022\017\n\007minutes\030\001 \001(\002\022\016\n\006points\030\002 \001(\002\022#\n\nfie" +
      "ldGoals\030\003 \001(\0132\017.FieldGoalStats\022&\n\rthreeP" +
      "ointers\030\004 \001(\0132\017.FieldGoalStats\022#\n\nfreeTh" +
      "rows\030\005 \001(\0132\017.FreeThrowStats\022\020\n\010rebounds\030" +
      "\006 \001(\002\022\017\n\007assists\030\007 \001(\002\022\016\n\006steals\030\010 \001(\002\022\016" +
      "\n\006blocks\030\t \001(\002\022\025\n\rpersonalFouls\030\n \001(\002\022\021\n" +
      "\tturnovers\030\013 \001(\002\"D\n\016FieldGoalStats\022\020\n\010at" +
      "tempts\030\001 \001(\002\022\014\n\004made\030\002 \001(\002\022\022\n\npercentage" +
      "\030\003 \001(\002\"D\n\016FreeThrowStats\022\020\n\010attempts\030\001 \001" +
      "(\002\022\014\n\004made\030\002 \001(\002\022\022\n\npercentage\030\003 \001(\002* \n\013" +
      "GameOutcome\022\007\n\003WIN\020\000\022\010\n\004LOSS\020\001*N\n\017GamePe" +
      "rformance\022\014\n\010TERRIBLE\020\000\022\007\n\003BAD\020\001\022\013\n\007AVER" +
      "AGE\020\002\022\010\n\004GOOD\020\003\022\r\n\tEXCELLENT\020\0042\231\001\n\010NbaSt" +
      "ats\022G\n\021SubscribeNbaStats\022\025.NbaStatsSubsc" +
      "ription\032\031.PlayerStatisticsResponse0\001\022D\n\021" +
      "GetSeasonAverages\022\026.SeasonAveragesReques" +
      "t\032\027.SeasonAveragesResponseB\026\n\003genB\rNbaSt" +
      "atsProtoP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_NbaStatsSubscription_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_NbaStatsSubscription_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_NbaStatsSubscription_descriptor,
        new java.lang.String[] { "PlayerId", "Seasons", });
    internal_static_SeasonAveragesRequest_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_SeasonAveragesRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_SeasonAveragesRequest_descriptor,
        new java.lang.String[] { "PlayerId", "Season", });
    internal_static_PlayerStatisticsResponse_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_PlayerStatisticsResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_PlayerStatisticsResponse_descriptor,
        new java.lang.String[] { "PlayerId", "Games", });
    internal_static_SeasonAveragesResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_SeasonAveragesResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_SeasonAveragesResponse_descriptor,
        new java.lang.String[] { "Averages", });
    internal_static_SeasonStatistics_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_SeasonStatistics_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_SeasonStatistics_descriptor,
        new java.lang.String[] { "Season", "AverageStats", });
    internal_static_GameStatistics_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_GameStatistics_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_GameStatistics_descriptor,
        new java.lang.String[] { "GameId", "Date", "Opponent", "Outcome", "GamePerformanceGrade", "Stats", });
    internal_static_DetailedStatistics_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_DetailedStatistics_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_DetailedStatistics_descriptor,
        new java.lang.String[] { "Minutes", "Points", "FieldGoals", "ThreePointers", "FreeThrows", "Rebounds", "Assists", "Steals", "Blocks", "PersonalFouls", "Turnovers", });
    internal_static_FieldGoalStats_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_FieldGoalStats_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_FieldGoalStats_descriptor,
        new java.lang.String[] { "Attempts", "Made", "Percentage", });
    internal_static_FreeThrowStats_descriptor =
      getDescriptor().getMessageTypes().get(8);
    internal_static_FreeThrowStats_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_FreeThrowStats_descriptor,
        new java.lang.String[] { "Attempts", "Made", "Percentage", });
    descriptor.resolveAllFeaturesImmutable();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
