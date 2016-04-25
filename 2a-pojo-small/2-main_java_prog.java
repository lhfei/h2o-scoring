import java.io.*;
import hex.genmodel.easy.RowData;
import hex.genmodel.easy.EasyPredictModelWrapper;
import hex.genmodel.easy.prediction.*;

public class main {
   private static String modelClassName = "test_airline_GBM_100k_SMALL";

   public static void main(String[] args) throws Exception {
     hex.genmodel.GenModel rawModel;
     rawModel = (hex.genmodel.GenModel) Class.forName(modelClassName).newInstance();
     EasyPredictModelWrapper model = new EasyPredictModelWrapper(rawModel);

//  Month DayofMonth DayOfWeek DepTime UniqueCarrier Origin Dest Distance dep_delayed_15min
//   c-7       c-25       c-3     615            YV    MRY  PHX      598                 N

     RowData row = new RowData();
     row.put("Month", "c-7");
     row.put("DayofMonth", "c-25");
     row.put("DayOfWeek", "c-3");
     row.put("DepTime", "615");
     row.put("UniqueCarrier", "YV");
     row.put("Origin", "MRY");
     row.put("Dest", "PHX");
     row.put("Distance", "598");

     BinomialModelPrediction p = model.predictBinomial(row);
     System.out.print(p.classProbabilities[1]);

   } 
}
