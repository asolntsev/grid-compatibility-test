# A sample project for testing compatibility

... between different versions of Selenium Java bindings and Selenium Grid


# Start grid
> ./gradlew :grid2:run    -- start Selenium Grid 2.53.1   on port 2222

> ./gradlew :grid3:run    -- start Selenium Grid 3.141.59 on port 3333

> ./gradlew :grid4:run    -- start Selenium Grid 4.1.2    on port 4444


# Run tests
> ./gradlew :tests2:test  -- runs tests on Selenium 2.53.1   (against all 3 grids)

> ./gradlew :tests3:test  -- runs tests on Selenium 3.141.59 (against all 3 grids)

> ./gradlew :tests4:test  -- runs tests on Selenium 4.1.2    (against all 3 grids)