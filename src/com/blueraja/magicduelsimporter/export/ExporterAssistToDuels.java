package com.blueraja.magicduelsimporter.export;

import com.blueraja.magicduelsimporter.carddata.CardDataManager;
import com.blueraja.magicduelsimporter.magicassist.Deck;
import com.blueraja.magicduelsimporter.magicassist.MagicAssistDeckManager;
import com.blueraja.magicduelsimporter.magicduels.MagicDuelsDeckManager;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public class ExporterAssistToDuels {
    public static void main(String[] args)
            throws IOException, SAXException, ParserConfigurationException, TransformerException {
        CardDataManager cardDataManager = new CardDataManager();
        MagicAssistDeckManager magicAssistDeckManager = new MagicAssistDeckManager(cardDataManager);
        MagicDuelsDeckManager magicDuelsDeckManager = new MagicDuelsDeckManager(cardDataManager);

        cardDataManager.readXml();

        Iterable<Deck> decks = magicAssistDeckManager.getDecks();
        magicDuelsDeckManager.writeDecks(decks);
    }
}
