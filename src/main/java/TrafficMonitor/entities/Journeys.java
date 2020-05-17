package TrafficMonitor.entities;//package thesis.TrafficMonitor.entities;

//import dtos.JourneyDto;
//import dtos.PositionDto;
//import dtos.SegmentDto;
//import dtos.VehicleDto;
//import org.apache.flink.api.common.functions.RichMapFunction;
//import org.apache.flink.api.common.typeinfo.TypeInformation;
//import org.apache.flink.api.common.typeinfo.Types;
//import org.apache.flink.api.java.io.RowCsvInputFormat;
//import org.apache.flink.configuration.Configuration;
//import org.apache.flink.streaming.api.datastream.DataStream;
//import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
//import org.apache.flink.streaming.api.functions.timestamps.AscendingTimestampExtractor;
//import org.apache.flink.types.Row;
//import org.joda.time.format.DateTimeFormat;
//import org.joda.time.format.DateTimeFormatter;
//
//public class Journeys {
//
//    private static TypeInformation[] inputFieldTypes = new TypeInformation[]{
//            Types.LONG, Types.STRING, Types.LONG, Types.STRING, Types.INT, Types.STRING,
//            Types.STRING, Types.LONG, Types.FLOAT, Types.LONG,
//            Types.LONG, Types.STRING, Types.DOUBLE
//    };
//
//    public static DataStream<JourneyDto> getJourneysDto(StreamExecutionEnvironment env, String csvFile) {
//
//        // create input format to read the CSV file
//        RowCsvInputFormat inputFormat = new RowCsvInputFormat(
//                null, // input path is configured later
//                inputFieldTypes,
//                "\n",
//                ",");
//
//        // read file sequentially (with a parallelism of 1)
//        DataStream<Row> parsedRows = env
//                .readFile(inputFormat, csvFile)
//                .returns(Types.ROW(inputFieldTypes))
//                .setParallelism(1);
//
//        // convert parsed CSV rows into TaxiRides, extract timestamps, and assign watermarks
//        return parsedRows
//                // map to Journey POJOs
//                .map(new JourneyDtoExtractMapper())
//                // define drop-off time as event-time timestamps and generate ascending watermarks.
//                .assignTimestampsAndWatermarks(new AscendingTimestampExtractor<JourneyDto>() {
//                    @Override
//                    public long extractAscendingTimestamp(JourneyDto journeyDto) {
//                        return journeyDto.getCurrentPosition().getTimestamp();
//                    }
//                });
//    }
//    public static class JourneyDtoExtractMapper extends RichMapFunction<Row, JourneyDto> {
//        private transient DateTimeFormatter formatter;
//
//        @Override
//        public void open(Configuration parameters) throws Exception {
//            super.open(parameters);
//            formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm");
//        }
//
//        @Override
//        public JourneyDto map(Row row) throws Exception {
//            // convert time string into timestamp (long)
//            long timestamp = formatter.parseDateTime((String) row.getField(1)).getMillis();
//            long expDateTime = formatter.parseDateTime((String) row.getField(6)).getMillis();
//
//
//            // create POJO and set all fields
//            VehicleDto vehicleDto = new VehicleDto(/*licensePlate*/(String) row.getField(3),
//                    /*speed*/(int)row.getField(4),
//                    /*dir*/(String)row.getField(5),
//                    expDateTime);
//            SegmentDto segmentDto = new SegmentDto(/*trafficRate*/(float)row.getField(8),
//                    /*valori initiale doar pentrua nu fi eroare de compilare*/
//                    0,0);
//            PositionDto positionDto = new PositionDto(timestamp,vehicleDto,segmentDto,
//                    /*latitude*/(long)row.getField(9),
//                    /*longitude*/(long)row.getField(10));
//            JourneyDto journeyDto = new JourneyDto();
//
//
//           // journey.setId((long) row.getField(0));
//            journeyDto.setCurrentPosition(positionDto);
//            journeyDto.setDestination((String) row.getField(11));
//            journeyDto.setEstimatedToll((double) row.getField(12));
//
//            return journeyDto;
//        }
//    }
//}
