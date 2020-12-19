package subway;

import subway.flowchart.FlowChart;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        DefaultData.setting();
        FlowChart.flowChart(scanner);
    }
}
