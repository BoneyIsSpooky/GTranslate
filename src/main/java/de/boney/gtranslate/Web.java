package de.boney.gtranslate;

import javax.xml.ws.http.HTTPException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Web {

    static CompletableFuture<String> getRawTranslationResponse(String source, String target, String text) {
        CompletableFuture<String> future = new CompletableFuture<>();
        ExecutorService service = Executors.newCachedThreadPool();
        service.submit(() -> {
            try {
                URL url = new URL("https://translate.googleapis.com/translate_a/single?client=gtx&sl="
                        + source + "&tl=" + target + "&dt=t&q=" + URLEncoder.encode(text, "UTF-8"));

                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setRequestProperty("User-Agent", "Mozilla/5.0");

                int code = connection.getResponseCode();

                if (code != HttpURLConnection.HTTP_OK)
                    future.completeExceptionally(new HTTPException(code));

                future.complete(convertStreamToString(connection.getInputStream()));

            } catch (IOException e) {
                future.completeExceptionally(new RuntimeException(e));
            }
        }); service.shutdown();

        return future;
    }

    static String decodeRawTranslationResponse(String response) {
        return response.replace("[", "").replace("]", "").replace("\"",
                "").split(",")[0];
    }

    private static String convertStreamToString(InputStream is) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line;
        try {
            while ((line = reader.readLine()) != null) sb.append(line).append("\n");
        } finally {
            is.close();
        }
        return sb.toString();
    }
}
