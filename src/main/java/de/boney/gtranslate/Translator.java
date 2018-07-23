package de.boney.gtranslate;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Translator {
    public static CompletableFuture<String> translate(final Language source, final Language target, final String text) {

        CompletableFuture<String> future = new CompletableFuture<>();

        ExecutorService service = Executors.newCachedThreadPool();
        service.submit(() -> {
            try {
                future.complete(
                        Web.getRawTranslationResponse(source == null ? "auto" : source.code, target.code, text)
                                .thenApplyAsync(Web::decodeRawTranslationResponse)
                                .get()
                );
            } catch (InterruptedException | ExecutionException e) {
                future.completeExceptionally(e);
            }
        }); service.shutdown();

        return future;
    }
}
