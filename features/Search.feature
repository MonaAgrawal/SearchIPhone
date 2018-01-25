


  Feature: To Search an IPhone 
      
      #Scenario: Launch the Google website and search IPhone
      #Given Launch the browser and open Google Website
      #When User enters search criteria as "IPhone" and click on Google Search button
      #Then IPhone - Google Search page get loaded
      #
      #Scenario: Navigate through search result page until find the link pointing to amazon.co.uk
      #Given Launch the browser and open Google Website
      #When User enters search criteria as "IPhone" and click on Google Search button
      #And IPhone - Google Search page get loaded
      #And Clicks on the link pointing to amazon.co.uk
      #Then Model URL should contains "amazon" and get printed
      #
      #Scenario: To get the name, price and URL of the largest Model
      #Given Launch the browser and open Google Website
      #When User enters search criteria as "IPhone" and click on Google Search button
      #And IPhone - Google Search page get loaded
      #And Clicks on the link pointing to amazon.co.uk
      #Then Model URL should contains "amazon" and get printed
      #And Name and price of the largest Model should get printed
      #
      Scenario: Product price should not be greater than £1000.00
      Given Launch the browser and open Google Website
      When User enters search criteria as "IPhone" and click on Google Search button
      And IPhone - Google Search page get loaded
      And Clicks on the link pointing to amazon.co.uk
      And Name and price of the largest Model should get printed
      And Price should not be greater than 1000
      