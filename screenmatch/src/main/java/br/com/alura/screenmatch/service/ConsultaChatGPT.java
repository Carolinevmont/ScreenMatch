package br.com.alura.screenmatch.service;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class ConsultaChatGPT {
    public static String obterTraducao(String texto) {
        OpenAiService service = new OpenAiService("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");


        CompletionRequest requisicao = CompletionRequest.builder()
                .model("gpt-3.5-turbo-instruct")
                .prompt("traduza para o português o texto: " + texto)
                .maxTokens(1000)
                .temperature(0.7)
                .build();


        var resposta = service.createCompletion(requisicao);
        return resposta.getChoices().get(0).getText();
    }
}