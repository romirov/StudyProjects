package QuizCardBuilder;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;

/**
 * создаем игровой движок, который будет загружать набор флеш карт и разыгрывать их для пользователя
 * метод go() - формирует и выводит на экран GUI
 * 
 * метод loadFile(File file) - считывает набор карточек из файла
 *
 * метод makeCard(String lineToPerse) - метод,вызываемый из loadFile#берет строку из текстового файла, делит ее на части(вопрос и ответ) и  создает новый объект QuizCard, а затем добавляет его в ArrayList с помощью CardList
 *
 * class NextCardListener - если вопрос, то показываем ответ, иначе показываем следующий вопрос(чтобы видели что это - устанавливаем флаг)
 *
 * class OpenMenuListener - вызов диалогового окна, позволяющее пользователю выбирать набор карточек для открытия
 *
 * @param
 */
public class QuizCardPlayer{

}
